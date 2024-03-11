#!/bin/bash

source /etc/profile

cd /data/BookManageBackend/eureka
mvn clean install package
cd /data/BookManageBackend
docker stop eureka && docker rm eureka
docker image rm eureka:bookmanage
docker build --build-arg MODULE_NAME=eureka -t eureka:bookmanage -f base.Dockerfile .
docker run -p 2000:2000 --name="eureka" -itd eureka:bookmanage /bin/bash

cd /data/BookManageBackend/bookprovider
mvn clean install package
cd /data/BookManageBackend
docker stop bookprovider && docker rm bookprovider
docker image rm bookprovider:bookmanage
docker build --build-arg MODULE_NAME=bookprovider -t bookprovider:bookmanage -f base.Dockerfile .
docker run -p 5000:5000 --name="bookprovider" -itd bookprovider:bookmanage /bin/bash

cd /data/BookManageBackend/bookconsumer
mvn clean install package
cd /data/BookManageBackend
docker stop bookconsumer && docker rm bookconsumer
docker image rm bookconsumer:bookmanage
docker build --build-arg MODULE_NAME=bookconsumer -t bookconsumer:bookmanage -f base.Dockerfile .
docker run -p 8000:8000 --name="bookconsumer" -itd bookconsumer:bookmanage /bin/bash
