# 🎓 Student Management System - Backend

A secure and scalable **Student Management System Backend** built using **Java Spring Boot**, **Spring Security**, **JWT Authentication**, **MySQL**, and **Spring Data JPA**. This project provides RESTful APIs for user authentication and student management.

---

## 🚀 Features

### 🔐 Authentication & Security

* User Registration
* User Login
* JWT (JSON Web Token) Authentication
* Password Encryption using BCrypt
* Protected APIs with Spring Security
* Stateless Session Management

### 👨‍🎓 Student Management

* Add Student
* View All Students
* View Student by ID
* Update Student Details
* Delete Student

### 🗄 Database

* MySQL Database
* Spring Data JPA (Hibernate)
* Automatic Table Creation and Updates

---

## 🛠 Tech Stack

* Java 21/22
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Postman
* Git & GitHub

---

## 📂 Project Structure

```text
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── config
 └── resources
```

---

## 🔑 Authentication APIs

### Register User

**POST** `/auth/register`

```json
{
  "username": "krishna",
  "password": "password123"
}
```

---

### Login User

**POST** `/auth/login`

```json
{
  "username": "krishna",
  "password": "password123"
}
```

Response

```json
{
  "token": "your_jwt_token"
}
```

---

## 👨‍🎓 Student APIs

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| GET    | /students      | Get all students  |
| GET    | /students/{id} | Get student by ID |
| POST   | /students      | Add a new student |
| PUT    | /students/{id} | Update student    |
| DELETE | /students/{id} | Delete student    |

> These APIs require a valid JWT token in the Authorization header.

---

## 🔒 Authorization Header

```text
Authorization: Bearer YOUR_JWT_TOKEN
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/Krishnaaa227/student-management-backend.git
```

### Navigate to Project

```bash
cd student-management-backend
```

### Configure Database

Create an `application.properties` file and configure:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

jwt.secret=YOUR_SECRET_KEY
jwt.expiration=86400000
```

### Run Project

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 🧪 Testing

The APIs can be tested using:

* Postman
* Thunder Client
* Insomnia

---

## 📌 Future Improvements

* Role-Based Authorization (ADMIN / USER)
* Student Search & Filtering
* Pagination & Sorting
* Swagger API Documentation
* File Upload
* Docker Support
* Unit & Integration Testing
* Deployment on Render or Railway
* React Frontend Integration

---

## 👨‍💻 Author

**Krishna Sheladiya**

* GitHub: https://github.com/Krishnaaa227
* LinkedIn: Krishna Sheladiya

---

## ⭐ If you found this project helpful, don't forget to give it a star!

