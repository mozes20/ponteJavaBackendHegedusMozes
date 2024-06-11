# Induljunk ki az OpenJDK 11 alapú képből
FROM openjdk:17-jdk-slim

# Az alkalmazás .jar fájljának másolása a build könyvtárból
COPY target/*.jar app.jar

# Az alkalmazás futtatása a belépési pontként
ENTRYPOINT ["java","-jar","/app.jar"]