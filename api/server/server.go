package server

import (
	"context"
	"io"

	"github.com/hashicorp/go-hclog"
	"github.com/nicholasjackson/pong/api/game"
	pb "github.com/nicholasjackson/pong/api/protos/pong"
	"google.golang.org/grpc"
)

// PongServer comment
type PongServer struct {
	logger       hclog.Logger
	playerClient pb.PongService_ClientStreamServer

	serverURI      string
	upstreamClient pb.PongService_ServerStreamClient
	upstreamServer pb.PongService_ServerStreamServer
	player         int
	g              *game.Game
}

// New creates a new server
func New(logger hclog.Logger, player int, serverURI string) *PongServer {
	return &PongServer{logger: logger, player: player, serverURI: serverURI}
}

// ClientStream handles connections to and from the game
func (s *PongServer) ClientStream(stream pb.PongService_ClientStreamServer) error {
	s.logger.Info("Started client stream")
	s.playerClient = stream

	if s.player == 1 {
		s.g = game.NewGame() // start a new game
	}

	// open a connection to the other API
	conn, err := grpc.Dial(s.serverURI, grpc.WithInsecure())
	if err != nil {
		return err
	}

	defer conn.Close()
	c := pb.NewPongServiceClient(conn)
	s.upstreamClient, err = c.ServerStream(context.Background())
	if err != nil {
		s.logger.Error("Unable to connect to upstream server")
		return err
	}

	// handle messages from the upstream server
	go func() {
		for {
			d, err := s.upstreamClient.Recv()
			if err == io.EOF {
				s.logger.Error("Upstream disconnected", "error", err)
				break
			}
			if err != nil {
				s.logger.Error("Upstream disconnected", "error", err)
				break
			}

			// got message forward it
			s.logger.Info("Received from Server", "Message", d)
			stream.Send(d)
		}
	}()

	// handle messages from the pong client
	for {
		in, err := stream.Recv()
		if err == io.EOF {
			s.logger.Error("Close received from player", "error", err)
			break
		}
		if err != nil {
			s.logger.Error("Close received from player", "error", err)
			break
		}

		s.logger.Info(
			"Got event", "handler", "client",
			"name", in.Name,
			"bat-x", in.X,
			"ball-y", in.Y)

		if s.player == 1 {
			s.handlePlayer1(in.Name)
		} else {
			s.handlePlayer2(in.Name)
		}
	}

	s.playerClient = nil

	if s.player == 1 {
		s.logger.Info("Player went away")
		// quit game
		s.g.ResetGame()
	}

	return nil
}

func (s *PongServer) handlePlayer1(m string) {
	switch m {
	case "RESET_GAME":
		s.g.HardReset()
	case "SERVE_1":
		s.g.StartGame(1)
		go s.gameTick()
	case "SERVE_2":
		s.g.StartGame(2)
		go s.gameTick()
	case "BAT_UP_1":
		s.g.MoveBatUp(1)
	case "BAT_DOWN_1":
		s.g.MoveBatDown(1)
	case "BAT_UP_2":
		s.g.MoveBatUp(2)
	case "BAT_DOWN_2":
		s.g.MoveBatDown(2)
	}

	s.sendUpdate()
}

func (s *PongServer) handlePlayer2(m string) {
	// forward the data to the other server
	s.upstreamClient.Send(&pb.Event{Name: m})
}

func (s *PongServer) gameTick() {
	t, c := s.g.Tick()

	for {
		select {
		case <-t:
			s.sendUpdate()
		case <-c:
			s.sendUpdate()
			s.logger.Info("Game reset")
			return
		}
	}
}

func (s *PongServer) sendUpdate() {
	dp := s.g.DataAsProto()
	s.logger.Info("Send Data", "data", dp)

	if s.upstreamServer == nil {
		s.logger.Info("Upstream server not connected")
	} else {
		s.upstreamServer.Send(dp)
	}

	if s.playerClient != nil {
		s.playerClient.Send(dp)
	}
}

// ServerStream handles connections to and from the server
func (s *PongServer) ServerStream(stream pb.PongService_ServerStreamServer) error {
	s.logger.Info("Started server stream")
	s.upstreamServer = stream

	for {
		in, err := stream.Recv()
		if err == io.EOF {
			s.logger.Error("Close received from player", "error", err)
			break
		}

		if err != nil {
			s.logger.Error("Close received from player", "error", err)
			break
		}

		s.logger.Info(
			"Got event", "name", in.Name,
			"bat-x", in.X,
			"bat-y", in.Y,
		)

		switch in.Name {
		case "SERVE_2":
			s.g.StartGame(2)
			go s.gameTick()
		case "BAT_UP_2":
			s.g.MoveBatUp(2)
		case "BAT_DOWN_2":
			s.g.MoveBatDown(2)
		}

		dp := s.g.DataAsProto()
		if s.playerClient == nil {
			s.logger.Info("Player 1 client not connected")
		} else {
			s.playerClient.Send(dp)
		}

		// send the position back
		stream.Send(dp)

		/*
			// forward the message to the client
			if s.serverClient == nil {
				s.logger.Info("No client connected")
				continue
			}

			err = s.serverClient.Send(in)
			if err != nil {
				s.logger.Error("Unable to send message to client: %s", err)
			}
		*/
	}

	s.logger.Info("Disconnected client")
	return nil
}
