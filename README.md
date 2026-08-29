Book Management System : 

Book Management System is a Spring Boot REST API for managing books with CRUD operations and cloud-based image upload support.

Overview :
Manage books with create, retrieve, update, and delete operations.
Store book metadata in PostgreSQL.
Upload and update book cover images using Cloudinary.
Demonstrates RESTful API design, file handling, and layered architecture.

Tech Stack
Language: Java 17
Framework: Spring Boot, Spring MVC, Spring Data JPA
Database: PostgreSQL, Hibernate JPA
Cloud Storage: Cloudinary
Build Tool: Maven or Gradle
Tools: Git, REST APIs, MultipartFile

Features
CRUD operations for books
Upload and update book cover images
Cloudinary integration for image storage
Retrieve books by ID
Search books by title
Layered architecture using Controller, Service, and Repository

Architecture : 

Controller → Service → Repository → PostgreSQL


