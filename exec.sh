#!/usr/bin/env bash
podman build -t sample-oauth2-spring-boot .
podman run -p 3000:3000 -it sample-oauth2-spring-boot