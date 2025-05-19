# Hotel Management System

A backend system built with Java and Spring Boot to manage hotel operations such as bookings, users, rooms, billing, and hotels.

## Tech Stack

- Java 23
- Spring Boot
- Spring Data JPA
- MySQL or H2 (for development)
- Maven

## Project Structure

management-system/
└── backend/ # Spring Boot hotel management backend

shell
Copy
Edit

## Setup Instructions

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd backend
Build the project:

bash
Copy
Edit
./mvnw clean install
Run the application:

bash
Copy
Edit
./mvnw spring-boot:run
The backend will start on http://localhost:8080

Features
User registration and management

Room availability and assignment

Hotel and room listings

Booking creation and tracking

Billing and invoice handling

Custom exception handling and validation

API Endpoints
User
POST /api/users - Create new user

GET /api/users/{id} - Get user by ID

Room
POST /api/rooms - Add new room

GET /api/rooms - Get all rooms

GET /api/rooms/{id} - Get room by ID

Hotel
POST /api/hotels - Add new hotel

GET /api/hotels - List all hotels

Booking
POST /api/bookings - Create a booking

GET /api/bookings/{id} - Get booking details

Billing
POST /api/bills - Generate a bill

GET /api/bills/{id} - Get billing info

