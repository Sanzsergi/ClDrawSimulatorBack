FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/cldraw-0.0.1.jar
COPY ${JAR_FILE} app_cldraw.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_cldraw.jar"]