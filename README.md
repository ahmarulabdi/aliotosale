# ALIOTOSALE
spesifikasi aplikasi DEV : 
1. Java versi 8 keatas
2. Maven
4. IDE bisa Spring Tool Suite (Eclipse), Netbean, Intellij, dll.
5. node js
6. npm
7. Angular CLI
8. MySQL Database
### Database MySQL `localhost:3306`
- create database mysql dengan nama aliotosale
### Backend Javaspring Spring Boot `localhost:8080`
- compile project dan run dengan cara `mvn clean install & mvn spring-boot:run`
- jika menggunakan IDE IntelliJ IDEA proses compile project dan run dengan cara di atas tidak perlu dilakukan
karena IDE sudah menyediakan build in compiler dan server sendiri
- dokumentasi rest api menggunakan Swagger dan Swagger UI di `http://localhost:8080/swagger-ui.html#/`
- koneksi database dengan mysql bisa dilihat di file application.property
### Frontend Angular 8 `localhost:4200`
- run npm install di src/main/frontend untuk instalasi angular dan dependency nya
- run ng serve untuk build in server dari Angular CLI

