version=v0.1.1

protos:
	protoc -I api/protos/ api/protos/api.proto --go_out=plugins=grpc:api/protos/pong

start-server-1:
	(cd api && PLAYER=1 BIND_PORT=6000 UPSTREAM_ADDRESS=localhost:6001 go run main.go)

start-server-2:
	(cd api && PLAYER=2 BIND_PORT=6001 UPSTREAM_ADDRESS=localhost:6000 go run main.go)
	
player-1:
	(cd cli && PLAYER=1 API_URI=localhost:6000 go run main.go)

player-2:
	(cd cli && PLAYER=2 API_URI=localhost:6001 go run main.go)

docker-java:
	cd java && docker build -t nicholasjackson/cloud-pong-api:java-${version} .
	docker push nicholasjackson/cloud-pong-api:java-${version}

docker-go:
	docker build -t nicholasjackson/cloud-pong-api:go-${version} -f api/Dockerfile .
	docker push nicholasjackson/cloud-pong-api:go-${version}

docker-all: docker-go docker-java
