# Gutendex API Data Management
This project is a Spring-based application that fetches and manages data from the [Gutendex API](https://gutendex.com/books), storing it in a database. It provides a console interface to retrieve and display information about authors and books.

## Features
- Fetches author and book data from the Gutendex API.
- Stores data in a local database for efficient querying.
- Console interface for users to interact with and retrieve stored information.
- Utilizes Spring framework for configuration management and database interaction.

## Requirements
- JDK 11 or higher
- Maven
- A database (e.g., H2, MySQL, PostgreSQL)

## Setup
### 1. Clone the repository:
```bash
git clone https://github.com/SebasDosman/books_gutendex_project.git
```
### 2. Install dependencies:
```bash
mvn install
```
### 3. Configure the database:
   Configure your application.properties or application.yml file with your database connection settings.
   Example for H2:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
For MySQL or PostgreSQL, adjust the settings accordingly.
### 4. Run the application:
   You can run the application via Maven:
```bash
mvn spring-boot:run
```
### 5. Interact via the console:
Once the application is running, use the console interface to query authors and books from the database. The application will prompt you for different options.

## Example Queries
- List all authors
- Search for books by title
- Retrieve books by a specific author

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments
- The Gutendex API provides free access to a vast collection of public domain books.
- This project leverages the power of Spring Framework for managing application configurations and database interactions.
