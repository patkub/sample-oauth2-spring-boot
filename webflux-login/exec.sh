#!/usr/bin/env bash
podman build -t sample-oauth2-spring-boot-webflux .
podman run -p 3001:3001 -it sample-oauth2-spring-boot-webflux