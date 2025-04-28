# Spring Boot CRUD Application with Thymeleaf

This project implements a CRUD (Create, Read, Update, Delete) application for managing employees in a database. It is built using Spring Boot, with MySQL as the database, and integrates Thymeleaf to render the user interface. The application follows the MVC (Model-View-Controller) design pattern for structuring its classes.

## Features
* Add Employee: Users can add new employee records to the database.

* Update Employee: Existing records can be edited with updated information.

* Delete Employee: Records can be removed from the database.

* Display Employee Table: All saved employee records are displayed in a tabular format on the web interface.

## Technology Stack
* Spring Boot: Provides the backend structure and simplifies development by integrating Spring Framework components.

* MySQL Database: Stores employee information. The SQL schema file is included in the repository to define the structure of the Employee object and facilitate database setup.

* MVC Pattern: Ensures separation of concerns:

    * Model: Defines the Employee entity and manages interaction with the database.

    * View: HTML templates designed using Thymeleaf to create the user interface.

    * Controller: Handles HTTP requests, interacts with the Model, and provides responses to the View.

* Thymeleaf: Renders the HTML user interface, including the table and buttons for CRUD operations.

* Spring Data JPA: Utilizes JPARepository to implement database operations, providing out-of-the-box support for CRUD functionalities.

## Project Structure
The application is structured to maintain clean separation of concerns:

* Model: Represents the data (e.g., Employee entity) and encapsulates business logic.

* View: HTML templates for displaying the user interface, designed with Thymeleaf.

* Controller: Handles incoming HTTP requests and passes data between the Model and the View.

## Employee Entity Structure
The Employee table in the database is set up to store the following fields:

* id: Unique identifier for each employee.

* name: Employee's first name.

* lastname: Employee's last name.

* email: Employee's contact email.

The SQL schema file in the repository defines these fields and ensures proper structure for database interaction.

## Installation and Usage
1. Clone the repository.

2. Import the project into your IDE (e.g., IntelliJ, Eclipse).

3. Configure application properties (application.properties) with your MySQL database details:

    * properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
    * spring.datasource.username=`<your-username>`
    * spring.datasource.password=`<your-password>`

4. Run the SQL schema file to set up the database that is found in sql-scripts/employee-directory-dav.sql

5. Start the application (SpringBootApplication class).

6. Access the web interface at http://localhost:8080.

## Additional Notes
This project leverages Spring Data REST to provide seamless integration with JPARepository, enabling rapid CRUD development. Thymeleaf ensures a dynamic and interactive user experience for managing employee data effectively.