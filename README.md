Crypto Business Platform Backend
This project is a backend application designed for a crypto business platform. The platform allows users to register, view their basic details, and retrieve cryptocurrency information from a third-party API. The backend is built using Java and Spring Boot, and the application is tested using Postman.

Table of Contents
Technology Stack
Database Structure
API Integration
User Flow Diagram
Getting Started
Installation
Running the Application
API Endpoints
Testing
Contributing
License
Technology Stack
Backend Framework: Spring Boot
Chosen for its simplicity, ease of setup, and wide adoption in Java-based projects. Spring Boot provides powerful dependency management and a large ecosystem of libraries.
Database: MySQL
Chosen for its ease of use, ability to handle structured data, and strong support for ACID (Atomicity, Consistency, Isolation, Durability) transactions. MySQL is widely used in enterprise applications and integrates well with Java through JDBC.
Database Structure
User Table
This table stores the basic details of each user registered on the platform.

Column Name	Data Type	Constraints
id	INT	PRIMARY KEY, AUTO_INCREMENT
name	VARCHAR	NOT NULL
email	VARCHAR	UNIQUE, NOT NULL
created_at	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP
Cryptocurrency Table
This table stores cryptocurrency details fetched from the third-party API.

Column Name	Data Type	Constraints
id	INT	PRIMARY KEY, AUTO_INCREMENT
user_id	INT	FOREIGN KEY (User Table)
coin_name	VARCHAR	NOT NULL
coin_price	DECIMAL	NOT NULL
timestamp	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP
ER Diagram
Below is a simplified ER diagram showing the relationship between the User and Cryptocurrency tables:

sql
Copy code
+-------------+          +--------------------+
|  User       |          |  Cryptocurrency     |
|-------------|          |---------------------|
| id (PK)     |<---------| user_id (FK)        |
| name        |          | coin_name           |
| email       |          | coin_price          |
| created_at  |          | timestamp           |
+-------------+          +--------------------+
API Integration
3rd Party API: Cashrich API
Request Handling
HTTP Client: Spring's RestTemplate or WebClient is used to handle HTTP requests to the third-party API. These clients allow for easy integration with RESTful APIs, including error handling and response mapping.

API Interaction: The application periodically fetches cryptocurrency data by making GET requests to the third-party API. The retrieved data is then processed and stored in the MySQL database.

Data Storage
Mapping API Response: The response from the API is mapped to the Cryptocurrency entity class, and the relevant data is stored in the cryptocurrency table.
User Flow Diagram
Below is a flow diagram that demonstrates how users interact with the platform:

User Registration: Users sign up and their details are stored in the User table.
User Login: Users log in to view their details.
Fetch Cryptocurrency Details: The platform fetches cryptocurrency data from the third-party API and stores it in the Cryptocurrency table.
Display Data: Users can view their details along with the latest cryptocurrency data.
sql
Copy code
+---------------+     +---------------+     +------------------+
| User Registers| --> | Fetch User    | --> | Fetch Crypto Data|
|               |     | Details       |     | from 3rd Party   |
|               |     |               |     | API              |
+---------------+     +---------------+     +------------------+
                                                     |
                                                     |
                                                +-------------+
                                                | Store in DB |
                                                +-------------+
Getting Started
Prerequisites
Java 8 or higher
MySQL
Maven
Postman
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/CSChaudhari/Crypto.git
cd Crypto
Set up the database:

Create a MySQL database named crypto_db.
Update the application.properties file with your MySQL credentials.
Build the project:

bash
Copy code
mvn clean install
Running the Application
Start the application:

bash
Copy code
mvn spring-boot:run
Access the application:

The application will be running on http://localhost:8080.

API Endpoints
Fetch Cryptocurrency Data:

sql
Copy code
GET /api/crypto/fetch
This endpoint fetches cryptocurrency data from the third-party API and stores it in the database.

Testing
Postman Collection: A Postman collection is provided for testing the API endpoints. Import the collection and run the tests against your local server.
Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

License
This project is licensed under the MIT License.
