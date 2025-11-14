
# 🎓 Student Management System — REST API (Spring Boot + JPA)

A clean and modular **Spring Boot REST API** for managing student records.  
This project demonstrates CRUD operations, DTO-based design, validation, error handling, and layered architecture — perfect for beginners and intermediate developers to learn **Spring Boot and REST API development**.

## 🚀 Features

✅ Create, Read, Update, Delete (CRUD) student data  
✅ Validation with `jakarta.validation` annotations  
✅ DTO-based architecture (no direct entity exposure)  
✅ Custom Exception Handling with `@ControllerAdvice`  
✅ Bulk student addition with duplicate-check handling   
✅ Clean layered design — Controller, Service, Repository, DTO, Mapper  

## 🧠 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend Framework** | Spring Boot (v3.x) |
| **Language** | Java 17+ |
| **ORM** | Hibernate / JPA |
| **Database** | MySQL (default), H2 (for testing) |
| **Validation** | Jakarta Validation (Hibernate Validator) |
| **Build Tool** | Maven |
| **API Testing** | Postman |

## 🏗️ Project Architecture

com.example.Student.Management
│
├── controller # REST endpoints
├── service # Business logic layer
│ ├── StudentService.java
│ └── StudentServiceImpl.java
├── repo # Repository layer (JPA)
│ └── StudentRepository.java
├── dto # Data Transfer Objects
│ ├── StudentCreateRequest.java
│ ├── StudentUpdateRequest.java
│ └── StudentResponse.java
├── entity # JPA entities
│ └── Student.java
├── mapper # Entity ↔ DTO mapping
│ └── StudentMapper.java
├── exception # Global error handling
│ └── GlobalExceptionHandler.java
└── StudentManagementApplication.java


## 🌐 API Endpoints
HTTP Method	Endpoint	Description 

POST	/api/v1/students	Add a new student

GET	/api/v1/students/{id}	Get a student by ID

GET	/api/v1/students	Get all students

PUT	/api/v1/students/{id}	Update an existing student

DELETE	/api/v1/students/{id}	Delete a student by ID

POST	/api/v1/students/bulk	Add multiple students (bulk add)

## 🧩 Validation Rules
Field	Validation	Example
firstName	@NotBlank	"Mahesh"
email	@Email + Unique	"mahesh@gmail.com"
phone	10 digits, unique	"9876543210"
dob	@Past	"2003-07-31"
branch	Optional	"CSE"
year	Range 1–4	2

## ⚡ Exception Handling
Exception	HTTP Code	Message
NotFoundException	404	"Student not found"
DataIntegrityViolationException	409	"Email already exists"
MethodArgumentNotValidException	400	"Validation failed"
GenericException	500	"Internal server error"
Centralized exception handling via GlobalExceptionHandler.

## 👨‍💻 Author
Mahesh Kakarla
🎓 MCA Student | 💻 Java & Spring Boot Developer
📍 Based in Bengaluru, India
📧 kakarlamahesh47@gmail.com
