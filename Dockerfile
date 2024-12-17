FROM maven:3.8.7-eclipse-temurin-19 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19-slim
COPY --from=build /target/ocrAPI-0.0.1-SNAPSHOT.jar ocrAPI.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ocrAPI.jar"]

