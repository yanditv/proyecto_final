# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo pom.xml y el archivo de configuración de Maven
COPY pom.xml /app
COPY mvnw /app
COPY .mvn /app/.mvn

# Descargar las dependencias del proyecto
RUN ./mvnw dependency:go-offline

# Copiar el código fuente del proyecto
COPY src /app/src

# Compilar el proyecto
RUN ./mvnw package -DskipTests

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/proyecto_final-0.0.1-SNAPSHOT.jar"]