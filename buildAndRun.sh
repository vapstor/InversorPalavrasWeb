#!/bin/sh
mvn clean package && docker build -t vapstor/Bridge .
docker rm -f Bridge || true && docker run -d -p 8080:8080 -p 4848:4848 --name Bridge vapstor/Bridge 
