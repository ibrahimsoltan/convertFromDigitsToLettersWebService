# Use the official OpenJDK base image
FROM openjdk:17.0.1-jdk-slim

# Set metadata for the image
LABEL maintainer="ibrahimsoltan2000@example.com"
LABEL version="1.0"
LABEL description="Spring Boot Application"

EXPOSE 8080

# Copy the built jar file into the image
COPY target/convert_fromm_digits_to_letters_web_service-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
