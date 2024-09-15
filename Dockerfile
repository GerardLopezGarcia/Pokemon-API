# Empezamos con una imagen base de Gradle para construir nuestra aplicación
FROM gradle:jdk17 as build

# Copiamos nuestro código fuente al contenedor
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Construimos la aplicación
RUN gradle clean build --no-daemon

# Ahora, empezamos con una imagen base de Java para ejecutar nuestra aplicación
FROM openjdk:17-jdk-alpine

# Copiamos el archivo jar de la etapa de construcción
COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar

# Exponemos el puerto 8080 para que nuestra aplicación sea accesible
EXPOSE 8080

# Definimos el comando para ejecutar nuestra aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]