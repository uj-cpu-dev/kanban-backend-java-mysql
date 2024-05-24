# Stage 1: Build (unchanged)
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY wait-for-it.sh /app/wait-for-it.sh

COPY target/kanban-project-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

# Stage 2: Test (new stage)
STAGE test

# Install dependencies for testing (if needed)
RUN apt-get update && apt-get install -y maven  # Example: Install Maven for tests

# Copy your test code and dependencies
COPY test/ /app/test

# Run your tests using the appropriate command (replace with your actual command)
CMD ["mvn", "test"]

# Stage 3: Run (unchanged)
# (Rest of your existing Dockerfile content remains the same)
ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "/app/app.jar"]