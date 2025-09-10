# 📌 To-Do List Backend (Spring Boot)

Este proyecto es el backend de la aplicación **To-Do List**, desarrollado con **Spring Boot** y **MySQL**.

---

## ⚙️ Configuración de la Base de Datos

Por seguridad, **las credenciales de la base de datos no están en el repositorio**.  
Cada desarrollador debe crear el archivo:


Este archivo **NO se sube al repo** porque está en el `.gitignore`.

---

## 📄 Ejemplo de `application-dev.properties`

```properties
# Configuración de la base de datos MySQL (solo local)
spring.datasource.url=jdbc:mysql://localhost:3306/todolistdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
