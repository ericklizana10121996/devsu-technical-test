FROM openjdk:17

# Set the work directory
WORKDIR /movement

# Copy the application JAR file to the container
COPY target/*.jar movement.jar

# Expose the port for the application
EXPOSE 8086

# Entry point to start the application
ENTRYPOINT ["java", "-jar", "movement.jar"]