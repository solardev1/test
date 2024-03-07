
# Proyecto


Prueba Técnica para Desarrollador Java, Spring Boot y Docker

Objetivo: Evaluar las habilidades del candidato en el desarrollo de aplicaciones Java con Spring Boot y la implementación de Docker para la contenerización y despliegue.


## Requisitos

* Java 17
* Maven
* Docker

## Instalación

* Descargar proyecto de Github utilizando un cliente GIT
* Abrir consola y desde el fichero del proyecto ejecutar el comando: mvn clean install
* Crear Imagen Docker utilizando los comandos:
  * docker build -t dev-220:3.0 .
  * Listar imagenes para obtener id de imagen con comando: docker images
  * Ejecutar comando: docker run -it -p 8080:8080 {id de imagen}

## EndPoints disponibles

* Crear Tarea: http://localhost:8080/tareas/crear
* Listar todas las tareas: http://localhost:8080/tareas/listar
* Borrar tarea: http://localhost:8080/tareas/borrar
* Actualizar tarea: http://localhost:8080/tareas/actualizar 