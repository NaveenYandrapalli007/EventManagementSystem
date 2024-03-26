# Event Management System

## Introduction

The Event Management System is a Java application designed to manage events and associated weather information. It is built using the following technologies:

- **Spring Boot**: Provides a robust framework for building and deploying Java-based applications, simplifying configuration and setup.
- **Hibernate**: Offers object-relational mapping (ORM) capabilities, enabling seamless interaction with the underlying MySQL database.
- **MySQL**: Chosen as the database management system for its reliability, scalability, and widespread adoption.

## Design Decisions

### Tech Stack Selection

- **Spring Boot**: Chosen for its rapid development capabilities, built-in dependency management, and extensive ecosystem of libraries and tools. It allows us to quickly set up a production-ready application with minimal configuration.
- **Hibernate**: Selected for its powerful ORM capabilities, which abstract away the complexities of database interactions and provide a more object-oriented approach to data persistence.
- **MySQL**: Preferred for its reliability, performance, and compatibility with Spring Boot and Hibernate. It offers robust features for managing relational data and is well-suited for this type of application.

### Challenges and Solutions

- **CSV Data Upload**: One challenge was implementing the functionality to upload event data via CSV files. This was addressed by leveraging Apache Commons CSV library to parse CSV files and map the data to Java objects, which are then persisted to the database using Hibernate.

- **Database Configuration**: Configuring the MySQL database connection properties in the application.properties file posed a challenge. This was resolved by carefully configuring the datasource settings in the Spring Boot configuration file.

## Setup Instructions

### Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven
- MySQL

### Setup Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/event-management-system.git
    ```

2. Navigate to the project directory:

    ```bash
    cd event-management-system
    ```

3. Configure MySQL database settings in `src/main/resources/application.properties`.

4. Build the project:

    ```bash
    mvn clean install
    ```

5. Run the application:

    ```bash
    mvn spring-boot:run
    ```

6. Access the application at [http://localhost:8080](http://localhost:8080) in your web browser.

## Usage

- Use the provided API endpoints to manage events and weather data.
- Use POSTMAN or any other API client to interact with the endpoints.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
