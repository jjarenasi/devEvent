#FROM openjdk:17-alpine
FROM openjdk:17
# Setting up work directory
WORKDIR /app
COPY target/*.jar app.jar
# Exposing port 8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]