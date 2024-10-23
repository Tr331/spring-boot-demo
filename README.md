# Spring Boot Student Register REST API

A simple Spring Boot REST API to manage student data. This project demonstrates basic CRUD operations and serves as an introduction to building RESTful web services using Spring Boot.

## Features

✅ Create new students
✅ Retrieve student information
✅ Delete student records
🚧 Update student information (Coming Soon)

## Technology Stack

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (you can modify this section if you're using a different database)
- Maven

## API Endpoints

### Get All Students
```http
GET http://localhost:8080/student
```

#### Response
```json
[
    {
        "studentId": 1,
        "name": "Jonas",
        "emailId": "jonas@gmail.com",
        "dateOfBirth": "2000-12-10",
        "age": 23
    },
    {
        "studentId": 2,
        "name": "Anna",
        "emailId": "anna@gmail.com",
        "dateOfBirth": "2000-07-27",
        "age": 24
    }
```

![image](https://github.com/user-attachments/assets/43a5d4ef-8f20-40c9-b79c-046b4e03172e)


### Create Student
```http
POST http://localhost:8080/student
```

#### Request Body
```json
{
    "name":"Thanos",
    "emailId":"Thanos.destroyer@gmail.com",
    "dateOfBirth":"1000-05-25"
}
```

![image](https://github.com/user-attachments/assets/3c3d74ad-1861-411d-bfc9-432509cb13a7)
![image](https://github.com/user-attachments/assets/1982108c-48fb-480e-bfe2-f9442e2b168e)


### Delete Student
```http
DELETE http://localhost:8080/student/{id}
```

![image](https://github.com/user-attachments/assets/d52af46c-6ca4-4e5d-b191-b92e50659246)
![image](https://github.com/user-attachments/assets/c5f567c6-d003-405b-856a-f93653aa7054)


### Update Student (Coming Soon)
```http
PUT http://localhost:8080/student/{id}
```

## Setup and Installation

1. Clone the repository
```bash
git clone [your-repository-url]
```

2. Navigate to the project directory
```bash
cd spring-boot-demo
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

The application will start running at `http://localhost:8080`

## Project Structure
```
spring-boot-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/student/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request
