FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ground-spring-app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]