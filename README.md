# Referral Tracking System (Backend APIs)

## 📌 Overview
The **Referral Tracking System** is a backend service built with **Spring Boot** that provides APIs for managing and tracking referrals. It enables users to create, update, and retrieve referral data efficiently.

## 🚀 Tech Stack
- **Spring Boot** – Backend framework
- **Spring Data JPA** – Database interaction
- **MySQL** – Database
- **Maven/Gradle** – Dependency management

## 📌 API Endpoints
### **Referrals**
| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| `POST` | `/api/users`          | Create a new referral        |
| `GET`  | `/api/users`          | Get all referrals            |
| `GET`  | `/api/users/{id}`     | Get referral by ID           |
| `PUT`  | `/api/users/{id}`     | Update referral details      |
| `DELETE` | `/api/users/{id}`     | Delete a referral            |
| `GET`  | `/api/users/download` | Download referrals as CSV |

### Steps:
1. Clone this repository:
   git clone https://github.com/karthikpadarthi/Referral_Tracking

2. Configure the Database:
   Update application.properties or application.yml with your database credentials.

3.  Build & Run the Application:
    mvn clean install
    mvn spring-boot:run

Test the API using cURL or Postman:
curl -X GET ""

## 🛠️ Dependencies

spring-boot-starter-web

spring-boot-starter-data-jpa

spring-boot-starter-validation

mysql-connector-java

## 📌 Contributing
Feel free to open issues or submit pull requests if you find any bugs or want to add features.