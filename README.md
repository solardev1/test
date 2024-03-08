
# Proyecto


Prueba Técnica para Desarrollador Java, Spring Boot y Docker

Objetivo: Evaluar las habilidades del candidato en el desarrollo de aplicaciones Java con Spring Boot y la implementación de Docker para la contenerización y despliegue.


## Requisitos de ejecucion
Para ejecutar este proyecto localmente, necesitarás tener instalado lo siguiente:
* Docker
* Java Development Kit (JDK)
* Maven



## Instrucciones de Uso

Sigue estos pasos para ejecutar el proyecto en tu entorno local:

1. Clonar el Repositorio en tu entorno local.
2. Abrir una terminal en la raiz del proyecto y ejecutar el siguiente comando; docker compose up --build

## Funcionalidades

* Listar todas las tareas
* Agregar una nueva tarea
* Eliminar una tarea
* Actualizar una tarea


## Endpoints de la API
Listar tareas; Metodo GET
* http://localhost:8080/tareas

Insertar tarea; Metodo POST
* http://localhost:8080/tarea
```json
{
    "id": 1,
    "nombre": "Tarea 1",
    "descripion": "Tarea 1 Descripcion"
}

Actualizar tarea; Metodo PUT
* http://localhost:8080/tarea/{id}
```json
{
    "id": 1,
    "nombre": "Tarea 2",
    "descripion": "Tarea 2 Descripcion"
}

Borrar tarea; metodo DELETE
* http://localhost:8080/tarea/1