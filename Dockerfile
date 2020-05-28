FROM openjdk:latest

ADD target/microservice-1.0.0-SNAPSHOT-exec.jar app.jar

ENTRYPOINT ["java","-jar","app.jar" ]

EXPOSE 8080