# Etapa 1: Construir o aplicativo usando uma imagem Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copie o POM principal
COPY mining-service/pom.xml .

# Copie todos os módulos
COPY mining-service/application ./application
COPY mining-service/domain ./domain
COPY mining-service/infrastructure ./infrastructure

# Baixar dependências e construir o projeto
RUN mvn clean install -DskipTests

# Etapa 2: Criar a imagem final usando uma imagem mais leve do JDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar o jar do build anterior
COPY --from=build /app/infrastructure/target/*.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Definir o comando para executar o jar
ENTRYPOINT ["java", "-jar", "app.jar"]
