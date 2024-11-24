# Lab Ecommerce APP

## Setting Up the Environment with Docker Compose

Navigate to the `docker` directory and run the following command to set up the environment:

```bash
cd docker && docker-compose up -d && cd ..
```

## Building the Project

To build the project, use the following command:

```bash
./gradlew build
``` 

## Running the Application

To run the Spring Boot application, use the following command:

```bash
./gradlew bootRun
``` 
## Accessing the Application
Once the environment is up and running, you can access the Swagger UI to explore the API:

Swagger URL: http://localhost:8080/swagger-ui/index.html