
# Proyecto Entregable


Prueba Técnica para Desarrollador Java, Spring Boot y Docker

Objetivo: Evaluar las habilidades del candidato en el desarrollo de aplicaciones Java con Spring Boot y la implementación de Docker para la contenerización y despliegue.


- En el repositorio se encuentra todo el codigo desarrollado.
- Se incluye una coleccion de postman para facilitar las pruebas (z01- CollectionSolarTest.postman_collection.json)
- El respectivo archivo dockerfile se encuentra en la raiz.
- Generar y ejecutar la imagen:
  - docker build apitareas2 .
  - docker run -p 8000:8080 apitareas2
