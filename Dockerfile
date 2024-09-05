FROM maven:3.8.5-eclipse-temurin-17

WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:go-offline

COPY . /app

RUN mvn clean install

EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["mvn", "spring-boot:run"]
