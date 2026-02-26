🏨 Hotel Booking System

🚀 Built at HCLTech Hackathon 2026

⸻

👥 Team: InnovateX

Team Members:
	•	Vaibhav Gupta
	•	Samyank
	•	Amresh Kumar
	•	Deepesh Shukla

Hackathon: HCLTech Hackathon 2026
Location: Galgotias University
Date: 26 February 2026

📌 Project Overview

This project is a Microservices-based Hotel Booking System built using:
	•	Spring Boot
	•	Spring Data JPA
	•	MySQL
	•	Eureka Service Discovery
	•	REST APIs
	•	React.js (Frontend)

The system enables:
	•	User registration
	•	Hotel management
	•	Room management
	•	Room booking
	•	Real-time availability updates
	•	Inter-service communication

  🏗️ Architecture

The system follows a Microservices Architecture:

Frontend (React.js)
        ↓
User Service (8082)
        ↓
Hotel Service (8081)
        ↓
MySQL Database

Services:
	1.	Hotel Service
	•	Manage hotels
	•	Manage rooms
	•	Update room availability
	•	Search by location
	2.	User Service
	•	Create users
	•	Create bookings
	•	Communicate with hotel-service
	•	Store booking records
	3.	Eureka Server
	•	Service registration
	•	Service discovery

⸻

🛠️ Tech Stack

Backend
	•	Java 21
	•	Spring Boot 3.2.5
	•	Spring Data JPA
	•	MySQL
	•	Eureka Server
	•	ModelMapper
	•	Swagger (OpenAPI)

Frontend
	•	React.js (Vite)
	•	Axios
	•	REST API Integration

⸻

🔄 Inter-Service Communication

The user-service communicates with hotel-service using:
	•	RestTemplate
	•	Service discovery via Eureka
	•	REST API calls

Before booking:
	•	User existence is verified
	•	Hotel existence is verified
	•	Room availability is validated
	•	Room count is reduced upon confirmation

  ▶️ How to Run the Project

1️⃣ Start MySQL

Ensure MySQL is running and database is created.
2️⃣ Start Eureka Server
mvn spring-boot:run
3️⃣ Start Hotel Service
4️⃣ Start User Service
5️⃣ Start Frontend
cd frontend
npm install
npm run dev

📡 API Endpoints

User Service (8082)
	•	POST /api/users
	•	GET /api/users
	•	POST /api/bookings

⸻

Hotel Service (8081)
	•	POST /api/hotels
	•	GET /api/hotels
	•	GET /api/hotels/search?location=
	•	PUT /api/rooms/{id}/availability

⸻

🧠 Key Highlights
	•	Clean Microservices Architecture
	•	Scalable & Modular Design
	•	RESTful API Design
	•	Real-time availability updates
	•	Cross-Origin handling
	•	Production-style layered architecture

🙌 Acknowledgment

Built with passion and teamwork by Team InnovateX at
HCLTech Hackathon 2026 – Galgotias University
