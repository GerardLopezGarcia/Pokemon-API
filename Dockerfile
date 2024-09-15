FROM gradle:jdk17 as build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-alpine

COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]

# docker build -t pokemon-api . :IMAGEN
# docker run -p 8080:8080 pokemon-api :CONTENEDOR