package objects

import (
	//	"fmt"
	tl "github.com/JoelOtter/termloop"
)

const (
	gameWidth  float64 = 1024
	gameHeight float64 = 768
)

// BallMoveEvent shut up
type BallMoveEvent struct {
	X int
	Y int
}

// BallHitEvent getting sick of this linter
type BallHitEvent struct{}

// BallScoreEvent fires when the ball hits the x limits
type BallScoreEvent struct {
	Player int
}

// Ball shutup linter
type Ball struct {
	*tl.Rectangle
	px           float64
	py           float64
	player       int
	isControlled bool
	isInPlay     bool
	isStarted    bool
	eventHandler func(e interface{})
	xVector      float64
	yVector      float64
	speed        float64
	initialSpeed float64
	screenX      int
	screenY      int
}

// NewBall shutup linter
func NewBall(x, y, w, h int, color tl.Attr, isControlled bool, player int, eventHandler func(e interface{})) *Ball {
	initialSpeed := 0.8
	xVector := initialSpeed
	if player == 2 {
		xVector = -initialSpeed
	}

	return &Ball{
		Rectangle:    tl.NewRectangle(x, y, w, h, color),
		px:           float64(x),
		py:           float64(y),
		player:       player,
		isControlled: isControlled,
		isInPlay:     true,
		isStarted:    !isControlled,
		eventHandler: eventHandler,
		xVector:      xVector,
		yVector:      0,
		speed:        initialSpeed,
		initialSpeed: initialSpeed,
		screenX:      0,
		screenY:      0,
	}
}

// Draw get stuffed linter
func (r *Ball) Draw(s *tl.Screen) {
	sx, sy := s.Size()
	_, by := r.Size()
	fsy := float64(sy)
	fby := float64(by)

	r.screenX = sx
	r.screenY = sy

	// is this the first draw if so set to center
	if r.py == 0 && r.isControlled {
		if r.player == 1 {
			r.py = (fsy / 2) - (fby / 2)
		} else {
			r.py = (fsy / 2) - (fby / 2)
			r.px = float64(sx) - 8
		}
		return
	}

	if r.py == 0 && !r.isControlled {
		if r.player == 1 {
			r.py = (fsy / 2) - (fby / 2)
			r.px = float64(sx) - 8
		} else {
			r.py = (fsy / 2) - (fby / 2)
		}
		return
	}

	// left collision only detect collisions if we are controlling the ball
	// the other player will get the message via a server event
	if r.px <= 0 && r.isInPlay && r.isControlled {
		// dont move
		r.isInPlay = false
		r.eventHandler(&BallScoreEvent{2})
	}

	// right collision
	if r.px >= gameWidth && r.isInPlay && r.isControlled {
		r.isInPlay = false
		r.eventHandler(&BallScoreEvent{1})
	}

	// if the ball goes out of bounds vertically flip the y direction
	if (r.py < 0 || r.py >= gameHeight) && r.isInPlay {
		r.yVector = -r.yVector
	}

	r.Rectangle.Draw(s)
}

// Tick shut up linter
func (r *Ball) Tick(ev tl.Event) {
	// press space to start the game

	if ev.Type == tl.EventKey && r.isControlled && r.isInPlay {
		switch ev.Key {
		case tl.KeySpace:
			r.isStarted = true
		}
	}

	if !r.isInPlay {
		return
	}

	if r.isControlled && r.isStarted {
		r.px += r.xVector * r.speed
		r.py += r.yVector * r.speed

		r.eventHandler(&BallMoveEvent{int(r.px), int(r.py)})
	}

	// before drawing the ball convert the game space into
	// the screen space
	xRatio := float64(r.screenX) / gameWidth
	yRatio := float64(r.screenY) / gameHeight

	xPos := r.px * xRatio
	yPos := r.py * yRatio

	// set the ball position relative to our own screen size
	//fmt.Println(r.screenX, r.screenY, xRatio, yRatio, xPos, yPos)
	r.SetPosition(int(xPos), int(yPos))
}

// GetPos shut up
func (r *Ball) GetPos() (int, int) {
	return int(r.px), int(r.py)
}

// SetPos shut up
func (r *Ball) SetPos(x, y int) {
	r.px = float64(x)
	r.py = float64(y)
}

// Collide comment
func (r *Ball) Collide(p tl.Physical) {
	if !r.isInPlay {
		return
	}

	// only detect a collision if it hits our controlled bat and we are not controlling the ball
	if bat, ok := p.(*Bat); ok && bat.IsControlled() && !r.IsControlled() {
		// increase the speed with every hit
		//r.speed = r.speed * 2

		r.isControlled = true
		r.eventHandler(&BallHitEvent{})

		// calculate the yVector based on the position of the ball hitting the bat
		_, ballPosY := r.Position()
		_, ballSizeY := r.Size()
		_, batPosY := bat.Position()
		_, batSizeY := bat.Size()

		// angle is based on the distance from the center
		cbat := batSizeY/2 + batPosY    // center of bat
		cball := ballSizeY/2 + ballPosY //center of ball

		r.yVector = (float64(cball-cbat) * r.speed) / 6
	}

}

// SetControl blah
func (r *Ball) SetControl(c bool) {
	r.isControlled = c
}

// IsControlled no
func (r *Ball) IsControlled() bool {
	return r.isControlled
}

// Reset the original settings of the ball
func (r *Ball) Reset(playerWin int) {
	r.isControlled = true
	// if we won the round hand the serve to the other player
	if r.player == playerWin {
		r.isControlled = false
	}

	r.px = 6
	r.py = 0
	r.SetPosition(int(r.px), int(r.py))
	r.isStarted = !r.isControlled
	r.isInPlay = true

	// reset the speed
	r.speed = r.initialSpeed
	r.xVector = r.initialSpeed
	r.yVector = 0
	if r.player == 2 {
		r.xVector = -r.initialSpeed
	}
}
