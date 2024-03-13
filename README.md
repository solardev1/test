# TASK - Tareas

- Este proyecto realiza un CRUD básico sobre una tabla tareas creada con H2 y Java JPA
- cumple eficientemente con dichas funcioes y cuenta con validacion importantes. 

## Requisitos

- Java 11 instalado en tu máquina.
- Docker instalado en tu máquina (opcional, si deseas ejecutar la aplicación en un contenedor Docker).
- Se puede levantar la aplicación localmente

## Ejecución

### Ejecución sin Docker

1. Clona este repositorio en tu máquina local.
2. Abre una terminal y navega al directorio raíz del proyecto.
3. Ejecuta el siguiente comando para compilar la aplicación:
4. Una vez compilada la aplicación, ejecuta el siguiente comando para iniciarla:
   java -jar deploy/task-1.0.0.jar
5. La aplicación estará disponible en http://localhost:8081.

### Ejecución con Docker

1. Clona este repositorio en tu máquina local.
2. Abre una terminal y navega al directorio raíz del proyecto.
3. Ejecuta el siguiente comando para construir la imagen Docker:
   docker build -t task-1.0.0.jar .
4. Una vez construida la imagen, ejecuta el siguiente comando para iniciar un contenedor:
   docker run -p 8081:8081 task-1.0.0.jar
5. La aplicación estará disponible en http://localhost:8081.

### Los diferentes metodos de ejecucion serian:
### Metodo GET --con o sin parametros
- http://localhost:8081/task/api/v1/taskList?estado=en_progreso&fecha_limite=2024-03-15
- http://localhost:8081/task/api/v1/taskList

### Metodo PUT
- http://localhost:8081/task/api/v1/updTask
- body
  {
  "id": 1,
  "nombre": "Hacer la compra",
  "descripcion": "Cambiar y mejorar un sistema de TRAFICO",
  "fecha_limite": "2024-07-30",
  "estado": "pendiente"
  }
### Metodo POST
- http://localhost:8081/task/api/v1/insTask
- body
  {
  {
  "nombre": "Preparar informe",
  "descripcion": "Redactar el informe mensual de ventas",
  "fecha_limite": "2024-03-20",
  "estado": "en_progreso"
  }

### Metodo DELETE
- http://localhost:8081/task/api/v1/delTask?id=1

  
## Contribución

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commits (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube los cambios a tu repositorio fork (`git push origin feature/nueva-funcionalidad`).
5. Crea un pull request.


