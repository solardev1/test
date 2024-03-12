# Start with a base image containing Java runtime
FROM openjdk:11

# Add Maintainer Info
LABEL maintainer="martin84zarate@gmail.com"

ENV TZ=America/Asuncion
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=deploy/task-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} task-1.0.0.jar

# Run the jar file
# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "task-1.0.0.jar"]
