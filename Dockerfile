FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean  package - DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build ./target/*.jar ticketReservation.jar
ENV SERVER_PORT=8282
CMD ["java","-jar","ticketReservation.jar"]
