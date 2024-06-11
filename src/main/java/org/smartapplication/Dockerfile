FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean  package - DskipTests
FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/*.jar LogisticsDelivery.jar
ENV SERVER_PORT=8282
CMD ["java","-jar","app.jar"]