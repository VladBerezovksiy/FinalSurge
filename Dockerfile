# Example Dockerfile, but doesn't work, so I haven't .jar file in this project

FROM maven:3.8.5-jdk-11-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]