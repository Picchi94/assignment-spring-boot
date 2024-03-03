# CSV Uploader Spring Boot Project

This is a simple Spring Boot application for uploading, retrieving, and managing CSV data. The application uses an in-memory H2 database to store CSV data.

## Features

- **Upload CSV Data:** Store CSV data in the in-memory H2 database.
- **Retrieve Data:** Fetch all data or data by a specific code.
- **Delete Data:** Clear all data from the database.

## Prerequisites

- Java 11 or later
- Maven

## Getting Started

### Clone the Repository

git clone https://github.com/your-username/csv-uploader.git
cd csv-uploader

#### Build and run 
mvn spring-boot:run (feel free to simply start the server with your preferred IDE)

##### Usage
Upload CSV Data
To upload CSV data, send a POST request to http://localhost:8080/csv/upload with a CSV file. You can use tools like Postman for this.

Retrieve All Data
To retrieve all data, send a GET request to http://localhost:8080/csv/all.

Delete All Data
To delete all data, send a DELETE request to http://localhost:8080/csv/delete.
