#!/bin/bash

echo "========== Deploying =========="
docker compose pull
docker compose up -d

echo "========== Deployment Completed =========="