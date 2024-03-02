# TestCorp Employee Directory

A spring boot application for performing CRUD operations on _TestCorp_ employee database.

## Project Setup
- Clone the project
- Create a mysql database to store employee data
- Add database name, username and password to application.properties file

___A sample is shown below___

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=username
spring.datasource.password=password
```

- Run the project. You can use
  - `./mvnw` command in your terminal
  - `run` button in your IDE after adding the spring-boot:run configuration