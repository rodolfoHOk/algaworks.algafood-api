FROM openjdk:17-slim

WORKDIR /app

COPY target/*.jar /app/api.jar

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]
