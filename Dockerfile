# Use a Debian-based JDK 24 image
FROM openjdk:24-jdk-bullseye AS build

# Install Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Set working directory
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the jar file
RUN mvn clean package -DskipTests

# -------------------------------
# Final image to run the app
# -------------------------------
FROM openjdk:24-jdk-bullseye

# Set working directory
WORKDIR /app

# Copy the built jar from the build stage to this image
COPY --from=build /app/target/*.jar app.jar

# Expose the port used in application.properties
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
