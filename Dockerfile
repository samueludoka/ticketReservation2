FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean  package - DskipTests
<<<<<<< HEAD
FROM openjdk:17
=======
FROM openjdk:17-jdk-slim
>>>>>>> 54f96c580fae2ed46dbe2801c646c4c4fff6af07
WORKDIR /app
COPY --from=build ./target/*.jar ticketReservation.jar
ENV SERVER_PORT=8282
CMD ["java","-jar","ticketReservation.jar"]
