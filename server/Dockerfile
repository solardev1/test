# Utiliza una imagen base de Java
FROM openjdk:17

WORKDIR /app

# Copia el proyecto al contenedor
COPY . .

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["./mvnw", "spring-boot:run"]