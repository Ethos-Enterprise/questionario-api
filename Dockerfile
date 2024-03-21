FROM openjdk:17
WORKDIR /app
COPY target/questionario-api.jar .
CMD ["java", "-jar", "questionario-api.jar"]