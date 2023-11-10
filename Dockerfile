FROM openjdk:17
WORKDIR /app
COPY target/questionario-app.jar .
CMD ["java", "-jar", "questionario-app.jar"]