# 📦 Spring Boot REST API Project – Online Bookstore

A robust RESTful **E-Commerce web service for Books** built with **Spring Boot**, featuring secure endpoints and data management using **Spring MVC**, **Spring Security**, **Spring Expression Language (SpEL)**, and **Spring Data JPA**.  
This project was developed to deepen understanding of API development, secure backend design, and domain modeling in Spring.

---

## 🚀 Features

- ✅ RESTful API architecture
- 🔐 Secured endpoints with Spring Security
- 🔍 Dynamic access control using Spring Expression Language (SpEL)
- 💾 CRUD operations with Spring Data JPA
- 📂 Layered architecture (Controller, Service, Repository)


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

 🧱 Domain Model (Entity Design)
 The project follows a well-structured Entity Relationship Model (ERM) to represent users, carts, and orders within the system:
  - User is the base entity for all roles in the system. 
  - Admin, Employee, and Customer all extend from User. 
  - Each User has a Cart which can contain multiple CartItems. 
  - A User can also place multiple Orders, and each Order contains CartItems that were selected at the time of checkout. 
  
  This design allows clean role separation and clear ownership of carts and orders per user.

  🔐 Authentication & Authorization 
 Security has been implemented using Spring Security, with role-based access control defined through SecurityFilterChain and PasswordEncoder.
  - Access control rules:
     a) Customers can access: View endpoints like book browsing, Their own order history 
     b) Employees can: update or delete orders/customers 
     c) Admins have: Full access to all system management features 
 
 This fine-grained access is achieved using method-level security annotations and Spring Expression Language (SpEL) to enforce dynamic rules based on the user’s role.

