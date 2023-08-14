# Sample-application-for-JWT-Authentication-Authorization-with-REST-APIs.

This repository contains a sample Java Spring Boot application demonstrating how to implement JSON Web Token (JWT) based authentication and authorization. The application showcases a basic user authentication flow using JWT tokens for securing API endpoints.

Table of Contents:
	1. Prerequisites
	2. Setup
	3. Usage
	4. Endpoints
	5. Authorization
	6. Configuration

1. Prerequisites:

	Before you begin, ensure you have the following installed:
		--> Java Development Kit (JDK) 8 or later
		--> Apache Maven
		--> Your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor

2. Setup:

	1. Generate project in Spring initializer with following dependencies:
		--> Spring Web
		--> Spring Security
		--> MYSQL Driver
		--> JWT

	11. Clone this repository to your local machine.

	111. Open the extracted file in your preferred IDE.

	1V. Run the application:
		The application should now be running at http://localhost:8080.

3. Usage:

	You can use tools like Postman or CURL to interact with the API endpoints. Below are some example API requests:

	1. Register a User:

	POST /register
	Content-Type: application/json

		{
		    "username": "newuser",
		    "password": "password123"
		    "email"	      : "emailid@google.com"
		}

	11. Authenticate and Get JWT Token:

	POST /authenticate
	Content-Type: application/json

		{
		    "username": "newuser",
		    "password": "password123"
		}

	111. Access Secured Endpoint

	Authorization: Bearer <YOUR_JWT_TOKEN>
	
4. Endpoints:

	POST /register: Register a new user.
	POST /authenticate: Authenticate user and retrieve JWT token.
	POST /books : Store the book detail in database.
	PUT /books: Modify the existing book detail in database.
	GET /book/bookid: Retrieve book detail by id.
	DELETE /book/bookid: Delete book detail by id.

5. Authorization:

	This application uses JWT tokens for authentication and authorization. Each JWT token is signed using a secret key. The token includes user roles and other claims, which are used to grant or deny access to specific endpoints.

6. Configuration:

	You can configure the application behavior by modifying the application.properties file or by providing environment variables.

	Key configuration options include:
		spring.datasource.url: Database connection URL.
		spring.datasource.username: Database username.
		spring.datasource.password: Database password.
		jwt.secret: Secret key for JWT token generation.

