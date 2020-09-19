FROM amazoncorretto:8-alpine-jre

MAINTAINER Robson Cassiano <robson.cordeiro777@gmail.com>

RUN apk --no-cache update && apk add --no-cache bash

VOLUME /tmp

WORKDIR /usr/app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /usr/app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app/app.jar"]
