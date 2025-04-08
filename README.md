# Spring Boot REST API Project 🔐📦

A robust RESTful web service built with **Spring Boot**, featuring secure endpoints and data management using **Spring MVC**, **Spring Security**, **Spring Expression Language (SpEL)**, and **Spring Data JPA**. This project was developed to deepen understanding of API development and backend security in Spring.

---

## 🚀 Features

- ✅ RESTful API architecture
- 🔐 Secured endpoints with Spring Security
- 🔍 Dynamic access control using Spring Expression Language (SpEL)
- 💾 CRUD operations with Spring Data JPA
- 📂 Layered architecture (Controller, Service, Repository)

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring MVC
- Spring Security
- Spring Expression Language (SpEL)
- Spring Data JPA
- MYSQL
- Maven (dependency management)
- Postman (for API testing)

---

## 📦 Installation & Setup

1. **Clone the repository:**
   ```bash
    git clone https://github.com/bishalmhrjan/bookonlineshop.git
    cd  bookonlineshop

2. Update your application.properties like here:
spring.application.name=onlinebookshop
# Database URL (replace "bookshop_db" with your actual database name)
spring.datasource.url=jdbc:mysql://localhost:3306/onlinebookstore?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true

    Database credentials
    spring.datasource.username=root
    spring.datasource.password=admin

    Hibernate settings
    spring.jpa.hibernate.ddl-auto=update 
    spring.jpa.show-sql=true               
    spring.jpa.properties.hibernate.format_sql=true   

     Dialect for MySQL
     spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect



