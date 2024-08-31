FROM openjdk:17

# Set the work directory
WORKDIR /gateway

# Copy the application JAR file to the container
COPY target/*.jar gateway.jar

# Expose the port for the application
EXPOSE 8082

# Entry point to start the application
ENTRYPOINT ["java", "-jar", "gateway.jar"]