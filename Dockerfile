# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the wait-for-it script
COPY wait-for-it.sh /app/wait-for-it.sh

# Copy the project's JAR file to the container
COPY target/kanban-project-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the wait-for-it script and then start the app
ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "/app/app.jar"]
