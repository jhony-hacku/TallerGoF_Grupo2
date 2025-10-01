# Usa la imagen oficial de OpenJDK 17
FROM openjdk:17-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia toda la estructura del proyecto
COPY src/main/java/creador/ /app/creador/
COPY src/main/java/visitor/ /app/visitor/

# Compila todos los archivos Java manteniendo la estructura de directorios
RUN javac creador/*.java
RUN javac visitor/*.java

# Por defecto ejecuta el patrón creador (Abstract Factory)
# Usa -cp . para buscar las clases en el directorio actual
CMD ["java", "-cp", ".", "creador.Main"]
