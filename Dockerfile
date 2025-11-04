# Etapa 1: Compilación con Maven y Java 21
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Construimos el JAR (sin ejecutar tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final ligera con Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiamos el jar construido
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto de la app (ajústalo si usas otro)
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
