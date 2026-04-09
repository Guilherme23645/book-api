FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .

RUN chmod +x mvnw && ./mvnw clean package

CMD ["java", "-jar", "target/your-app-name-0.0.1-SNAPSHOT.jar"]