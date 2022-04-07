# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /app/src
# COPY pom.xml /app
# RUN mvn -f /app/pom.xml clean package

# FROM openjdk:11
# COPY --from=build /app/target/ProductService-0.0.1-SNAPSHOT.jar ProductService-0.0.1-SNAPSHOT.jar
# EXPOSE 8080
# ENTRYPOINT [ "java","-jar","ProductService-0.0.1-SNAPSHOT.jar" ]

FROM openjdk:11 
ADD /target/ProductService-0.0.1-SNAPSHOT.jar ProductService-0.0.1-SNAPSHOT.jar
EXPOSE 7070
ENTRYPOINT ["java","-jar","ProductService-0.0.1-SNAPSHOT.jar"]