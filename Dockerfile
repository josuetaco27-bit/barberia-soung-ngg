# Usamos una imagen oficial de Java 17 compacta
FROM eclipse-temurin:17-jdk-alpine

# Creamos el directorio de trabajo dentro del servidor
WORKDIR /app

# Copiamos todo nuestro código al servidor
COPY . .

# Compilamos las clases de Java de la barbería
RUN mkdir -p bin && javac -d bin src/com/barberia/model/Reserva.java src/com/barberia/controller/GestorReservas.java

# Exponemos el puerto estándar para servicios web en la nube
EXPOSE 8080

# Comando para arrancar tu servidor (Render lo manejará automáticamente con la web)
CMD ["java", "-cp", "bin", "com.barberia.controller.GestorReservas"]