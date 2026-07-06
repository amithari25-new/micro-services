#!/bin/bash

set -e

echo "========== Building Images =========="
docker compose build

echo "========== Tagging Images =========="
#docker tag discovery-service:latest iamamithari/discovery-service:1.0
#docker tag api-gateway:latest iamamithari/api-gateway:1.0
#docker tag user-service:latest iamamithari/user-service:1.0
#docker tag hotel-service:latest iamamithari/hotel-service:1.0
#docker tag rating-service:latest iamamithari/rating-service:1.0

echo "========== Pushing Images =========="
#docker push iamamithari/discovery-service:1.0
#docker push iamamithari/api-gateway:1.0
#docker push iamamithari/user-service:1.0
#docker push iamamithari/hotel-service:1.0
#docker push iamamithari/rating-service:1.0

echo "========== pushed to Docker Hub =========="