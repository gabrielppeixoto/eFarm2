FROM openjdk:18-alpine3.13
WORKDIR /app
COPY . .
RUN ./mvnw dependency:go-offline
RUN ./mvnw package
EXPOSE 8080
CMD ./mvnw spring-boot:run