### BUILD STEP ###
FROM maven:3.6.0-jdk-8-alpine AS BUILD

WORKDIR /usr/local/app
COPY . .

RUN mvn clean install

### RUN STEP ###
FROM openjdk:8-jre-slim

COPY --from=BUILD /usr/local/app/target/movieService-0.0.1-SNAPSHOT /usr/local

WORKDIR /usr/local
EXPOSE 8001
CMD java -jar movieService-0.0.1-SNAPSHOT
