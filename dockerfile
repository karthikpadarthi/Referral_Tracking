FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/required-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "app.jar"]
