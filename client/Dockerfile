# Utiliza una imagen base de Node para construir el proyecto
FROM node:20.3.1 as build

WORKDIR /app

# Copia los archivos de configuración del proyecto
COPY package.json .
COPY package-lock.json .

# Instala las dependencias
RUN npm install

# Copia el resto del código fuente
COPY . .

# Construye la aplicación
RUN npm run build

# Utiliza una imagen base de Nginx para servir la aplicación
FROM nginx:stable-alpine

# Copia los archivos construidos desde la etapa de construcción
COPY --from=build /app/dist /usr/share/nginx/html

# Expone el puerto 80
EXPOSE 80

# Inicia Nginx y mantiene el proceso en primer plano
CMD ["nginx", "-g", "daemon off;"]