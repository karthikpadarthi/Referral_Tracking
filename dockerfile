# Use official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/*.jar app.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]
