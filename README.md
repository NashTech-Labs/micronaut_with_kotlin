
# Micronaut with Kotlin

This is a simple Micronaut application for managing employee data. It provides basic CRUD (Create, Read, Update, Delete) operations for employees.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 19 or higher
- MySQL database server
- Gradle build tool (optional if using an IDE with Gradle support)

## Getting Started

Follow these steps to set up and run the Micronaut application:

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/micronaut-kotlin-employee-management.git

### Configure your MySQL database connection in the src/main/resources/application.yml or application.properties file :
```
datasources:
default:
url: jdbc:mysql://localhost:3306/your_database_name
driverClassName: com.mysql.cj.jdbc.Driver
username: your_database_username
password: your_database_password 
```

### The application will start, and you can access the API at http://localhost:8080.

API Endpoints

The following API endpoints are available:

    Get Employee by ID: GET /employee/{id}
    Get All Employees: GET /employee/all-employee-data
    Create Employee: POST /employee/create-employee
    Update Employee by ID: PUT /employee/{id}
    Delete Employee by ID: DELETE /employee/{id}


### Technologies Used

    Micronaut: A modern microservices framework for the JVM.
    Kotlin: A concise and expressive language for JVM development.
    MySQL: A relational database used for storing employee data.
    Gradle: A build automation tool used for managing project dependencies and building the application.

License

This project is licensed under the MIT License - see the LICENSE file for details.

## About the Author

This tech hub is maintained by [Rishika Kumari](https://www.linkedin.com/in/rishika-tiwari20), a passionate developer and tech enthusiast. Feel free to connect with them on LinkedIn to learn more about their work and stay updated on the latest developments