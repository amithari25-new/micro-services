#!/bin/bash

docker compose up -d

echo "Application Started"




#echo "Pulling latest code..."
#git pull
#
#echo "Building..."
#mvn clean package -DskipTests
#
#echo "Deploying..."
#docker compose down
#docker compose up --build -d
#
#echo "Deployment Successful"