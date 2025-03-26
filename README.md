# Spring Security Exampl

## Overview
This project demonstrates how to implement **Spring Security** in a Spring Boot application. It covers authentication, authorization, JWT-based security, and role-based access control.

## Features
- User authentication with **Spring Security**
- Role-based authorization (Admin/User)
- JWT-based authentication
- Secure REST APIs with role-based access control
- Exception handling for authentication failures

## Technologies Used
- **Java** (JDK 17+)
- **Spring Boot 3+**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **MySQL / H2 Database**
- **Lombok**
- **Postman (for API testing)**

## Project Setup
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- MySQL (optional for persistent storage)
- Postman (for API testing)

### Installation Steps
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/SpringSecurityExample.git
   cd SpringSecurityExample
   ```
2. **Configure Database (if using MySQL):**
   Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/security_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. **Build and Run the project:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Authenticate and get JWT token |
| GET | `/user/home` | Accessible by authenticated users |
| GET | `/admin/dashboard` | Accessible only by ADMIN role |

## JWT Authentication
After a successful login, you will receive a JWT token. Use this token in the `Authorization` header for accessing secured APIs:
```
Authorization: Bearer YOUR_JWT_TOKEN
```
