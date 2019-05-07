#!/usr/bin/env bash
set -e

./mvnw clean package -Pnative
docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-playground .
