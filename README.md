# Proyecto


Prueba Técnica para Desarrollador Java, Spring Boot y Docker

Objetivo: Evaluar las habilidades del candidato en el desarrollo de aplicaciones Java con Spring Boot y la implementación de Docker para la contenerización y despliegue.

Observaciones:
- Se incluye todo el codigo.
- Se incluye una coleccion de postman para facilitar las pruebas(z01- CollectionSolarTest.postman_collection.json)
- Pasos para generar y correr la imagen de docker (en la coleccion el puerto es 8000):
  - docker build apitareas2 .
  - docker run -p 8000:8080 apitareas2
