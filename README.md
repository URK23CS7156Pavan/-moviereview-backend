# Movie Review Backend

This is the backend for the Movie Review application, built using **Spring Boot**. It provides the API to manage movies, reviews, users, and other relevant data. The backend connects to a MySQL database and supports various endpoints for user interactions.

## Features

- **Movie Management**: Allows adding, updating, and deleting movies.
- **Review System**: Users can add, edit, and delete reviews for movies.
- **Database Integration**: Connects to a MySQL database for data persistence.

## Technologies Used

- **Spring Boot**: The main framework used for building the backend.
- **Spring Data JPA**: For interacting with the MySQL database.
- **MySQL**: The database used for data storage.

## Setup Instructions

### 1. Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/URK23CS7156Pavan/-moviereview-backend.git
cd moviereview-backend
2. Install Dependencies
Ensure you have Java and Maven installed. You can verify their installation using:

bash

java -version
mvn -version
If the dependencies are not installed, download and install them from their respective websites.

3. Configure the Database
In the src/main/resources/application.properties file, update the database connection details:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/moviedb
spring.datasource.username=<your_db_username>
spring.datasource.password=<your_db_password>
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
4. Run the Application
You can run the application by using the following Maven command:

bash

mvn spring-boot:run
Alternatively, if you have an IDE like IntelliJ IDEA or Eclipse, you can run the application directly from the IDE.

5. Access the API


Movies:

GET /api/movies

POST /api/movies

PUT /api/movies/{id}

DELETE /api/movies/{id}

Reviews:

GET /api/reviews/{movieId}

POST /api/reviews

DELETE /api/reviews/{id}

