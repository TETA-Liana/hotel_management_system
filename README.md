# User and Item Management System

A full-stack application for managing users and items (products) with authentication and CRUD operations.

## Tech Stack

### Backend

- Spring Boot
- Spring Data JPA
- H2 Database (for development)
- Java 17

### Frontend

- React.js
- Axios for API calls
- React Router for navigation
- Tailwind CSS for styling

## Project Structure

```
management-system/
├── backend/           # Spring Boot application
└── frontend/         # React application
```

## Setup Instructions

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Build the project:
   ```bash
   ./mvnw clean install
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The backend will start on http://localhost:8080

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
   The frontend will start on http://localhost:3000

## Features

- User Authentication (Signup/Login)
- Product Management (CRUD operations)
- Responsive UI with Tailwind CSS
- Session-based authentication

## API Endpoints

### Authentication

- POST /api/auth/signup - Register new user
- POST /api/auth/login - User login

### Products

- GET /api/products - Get all products
- POST /api/products - Create new product
- GET /api/products/{id} - Get product by ID
- PUT /api/products/{id} - Update product
- DELETE /api/products/{id} - Delete product
