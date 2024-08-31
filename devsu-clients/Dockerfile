FROM openjdk:17

# Set the work directory
WORKDIR /clients

# Copy the application JAR file to the container
COPY target/*.jar clients.jar

# Expose the port for the application
EXPOSE 8085

# Entry point to start the application
ENTRYPOINT ["java", "-jar", "clients.jar"]