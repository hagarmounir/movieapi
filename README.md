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

