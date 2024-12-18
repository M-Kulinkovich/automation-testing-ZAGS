FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY testng.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN  mvn clean test -DsuiteXmlFile=testng

FROM openjdk:21

WORKDIR /app
COPY --from=build /app/target /app/target
CMD ["mvn", "clean", "test", "-DsuiteXmlFile=testng"]

