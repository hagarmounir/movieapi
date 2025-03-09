This is the backend API for a movie management system built with Spring Boot, Spring Security, JPA, and MySQL. It supports admin and user roles, with authentication, movie management, and pagination.

⚙️ Technologies Used
Java 17
Spring Boot 3+
Spring Security
Spring Data JPA (Hibernate)
MySQL
Pagination with Pageable
RestTemplate (OMDB API)

📌 Features
✅ User Authentication (Login & Signup)
✅ Role-Based Access Control (Admin/User)
✅ Movie Management (Add, Remove, View)
✅ Pagination for Movie Retrieval
✅ OMDB API Integration (Search & Fetch Movies)
✅ Secure API with Spring Security

📌 Setup Instructions
🔹 1. Clone the Repository
git clone https://github.com/your-username/movieapi.git
cd movieapi
🔹 2. Configure MySQL Database
Open src/main/resources/application.properties and set your MySQL credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/movieapp
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
👉 Make sure MySQL is running and the database exists!
🔹 3. Build & Run the Application
mvn spring-boot:run
The backend will start at:
👉 http://localhost:8080

📌 Testing With Postman
Go to Postman
Set Authorization Type: Basic Auth
Admin Login:
Username: admin
Password: admin123
User Login:
Username: user
Password: user123
Test API Endpoints : https://documenter.getpostman.com/view/42947435/2sAYdoFTDA
