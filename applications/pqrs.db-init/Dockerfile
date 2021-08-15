FROM openjdk:8-jdk-alpine
WORKDIR /app
EXPOSE 8080
ARG JAR_FILE=build/libs/applications-pqrs.db-init.jar
COPY ${JAR_FILE} /app/pqrsTest.jar
ENTRYPOINT ["java","-jar","/app/pqrsTest.jar"]
