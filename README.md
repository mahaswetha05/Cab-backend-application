# 🚖 Cab Booking System – Spring Boot Backend Project

## 📖 Project Overview

The **Cab Booking System** is a role-based backend application developed using **Spring Boot**, **Spring Security**, **Spring Data JPA**, **Hibernate**, and **MySQL**.

The application simulates a real-world cab booking workflow:

* Passenger books a ride.
* Admin assigns a driver.
* Driver starts and completes the ride.
* Drivers can register their vehicles.
* Security is implemented using HTTP Basic Authentication and Role-Based Authorization.

---

# 🛠 Tech Stack

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database Operations            |
| Hibernate       | ORM Framework                  |
| MySQL           | Database                       |
| Maven           | Dependency Management          |
| Postman         | API Testing                    |

---

# 📂 Project Architecture

```text
Client (Postman)
       |
       v
Controller Layer
       |
       v
Service Layer
       |
       v
DAO / Repository Layer
       |
       v
MySQL Database
```

---

# 📦 Package Structure

```text
src/main/java/com/example/cab

├── controller
├── service
├── dao
├── model
├── dto
├── security
└── CabApplication.java
```

---

# 🏗 Model Layer

The Model Layer contains JPA entities mapped to MySQL tables.

---

## User Entity

Represents Admin, Driver, and Passenger.

### Fields

| Field    | Type   |
| -------- | ------ |
| id       | int    |
| name     | String |
| email    | String |
| phno     | String |
| password | String |
| role     | Role   |

### Roles

```java
ADMIN
DRIVER
PASSENGER
```

---

## Ride Entity

Represents a cab ride.

### Fields

| Field          | Type       |
| -------------- | ---------- |
| id             | int        |
| pickupLocation | String     |
| dropLocation   | String     |
| passenger      | User       |
| driver         | User       |
| fare           | int        |
| status         | RideStatus |

---

## Vehicle Entity

Represents driver's vehicle.

### Fields

| Field    | Type   |
| -------- | ------ |
| id       | int    |
| vechNo   | String |
| vechType | String |
| driver   | User   |

### Relationship

```java
@OneToOne
User driver;
```

---

## RideStatus Enum

```java
REQUESTED
ACCEPTED
STARTED
COMPLETED
CANCELLED
```

---

# 📩 DTO Layer

DTOs are used to transfer request data between client and server.

---

## RideRequest DTO

Used while booking rides.

```java
public class RideRequest {

    private String pickup;
    private String drop;
}
```

### Example Request

```json
{
    "pickup":"Chennai Central",
    "drop":"T Nagar"
}
```

---

# 🗄 DAO Layer (Repository)

DAO layer communicates with the database.

---

## UserRepo

```java
public interface UserRepo
extends JpaRepository<User,Integer> {

    Optional<User> findByName(String name);
}
```

---

## RideRepo

```java
public interface RideRepo
extends JpaRepository<Ride,Integer> {
}
```

---

## VehicleRepo

```java
public interface VehicleRepo
extends JpaRepository<Vehicle,Integer> {
}
```

---

# ⚙ Service Layer

Contains business logic.

---

## UserService

### Register User

```java
public User regUser(User u)
```

Functions:

* Registers Admin
* Registers Driver
* Registers Passenger
* Encrypts password using BCrypt

---

## RideService

### Book Ride

```java
requestRide()
```

Creates ride request.

---

### Assign Driver

```java
assigndriver()
```

Assigns driver to ride.

---

### Start Ride

```java
startRide()
```

Changes status to:

```java
STARTED
```

---

### Complete Ride

```java
completeRide()
```

Changes status to:

```java
COMPLETED
```

---

### Cancel Ride

```java
cancellRide()
```

Changes status to:

```java
CANCELLED
```

---

## VehicleService

### Add Vehicle

```java
addVehicle()
```

Stores vehicle information.

---

# 🎮 Controller Layer

Handles HTTP Requests.

---

## AuthController

### Register User

```http
POST /auth/register
```

---

## UserController

### Book Ride

```http
POST /passenger/ride/{passengerId}
```

---

## AdminController

### Assign Driver

```http
PUT /admin/assign/{rideId}/{driverId}
```

---

## DriverController

### Start Ride

```http
PUT /driver/start/{rideId}
```

### Complete Ride

```http
PUT /driver/complete/{rideId}
```

---

## VehicleController

### Add Vehicle

```http
POST /vehicle/add/{driverId}
```

---

# 🔐 Security Layer

Implemented using Spring Security.

---

## CustomerUserDetailService

Loads user from database.

```java
User u =
repo.findByName(name)
.orElseThrow(...);
```

Builds authenticated user.

```java
User.withUsername(...)
```

---

## SecurityConfig

### Password Encoder

```java
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

---

## Authorization Rules

```java
/admin/**      -> ADMIN

/driver/**     -> DRIVER

/passenger/**  -> PASSENGER
```

---

## Authentication Type

```text
HTTP Basic Authentication
```

---

# 🗃 MySQL Database

Database Name:

```sql
cab
```

---

## Tables

### user

Stores:

* Admin
* Driver
* Passenger

---

### ride

Stores:

* Pickup Location
* Drop Location
* Driver
* Passenger
* Fare
* Status

---

### vehicle

Stores:

* Vehicle Number
* Vehicle Type
* Driver

---

# 🔄 Hibernate & JPA

### Hibernate

Hibernate converts Java Objects into Database Records.

Example:

```java
Ride ride = new Ride();
```

Hibernate generates:

```sql
insert into ride (...)
```

---

### JPA

JPA provides ready-made methods:

```java
save()
findById()
findAll()
deleteById()
```

through:

```java
JpaRepository
```

---

# 📮 API Testing Using Postman

---

## 1. Register Passenger

### Endpoint

```http
POST /auth/register
```

### Body

```json
{
  "name":"Max",
  "email":"max@gmail.com",
  "phno":"9876543213",
  "password":"max123",
  "role":"PASSENGER"
}
```

---

## 2. Register Driver

```json
{
  "name":"John",
  "email":"john@gmail.com",
  "phno":"9876543212",
  "password":"john123",
  "role":"DRIVER"
}
```

---

## 3. Register Admin

```json
{
  "name":"Ram",
  "email":"ram@gmail.com",
  "phno":"9876543211",
  "password":"ram123",
  "role":"ADMIN"
}
```

---

## 4. Add Vehicle

### Auth

```text
Username: John
Password: john123
```

### Endpoint

```http
POST /vehicle/add/{driverId}
```

### Body

```json
{
  "vechNo":"TN01AB1234",
  "vechType":"CAR"
}
```

---

## 5. Book Ride

### Auth

```text
Username: Max
Password: max123
```

### Endpoint

```http
POST /passenger/ride/{passengerId}
```

### Body

```json
{
    "pickup":"Chennai Central",
    "drop":"T Nagar"
}
```

---

## 6. Assign Driver

### Auth

```text
Username: Ram
Password: ram123
```

### Endpoint

```http
PUT /admin/assign/{rideId}/{driverId}
```

No Body Required.

---

## 7. Start Ride

### Auth

```text
Username: John
Password: john123
```

### Endpoint

```http
PUT /driver/start/{rideId}
```

No Body Required.

---

## 8. Complete Ride

### Auth

```text
Username: John
Password: john123
```

### Endpoint

```http
PUT /driver/complete/{rideId}
```

No Body Required.

---

# 🚀 Complete Workflow

```text
1. Register Passenger (Max)

2. Register Driver (John)

3. Register Admin (Ram)

4. Driver Adds Vehicle

5. Passenger Books Ride

6. Admin Assigns Driver

7. Driver Starts Ride

8. Driver Completes Ride
```

---

# 🎯 Future Enhancements

* JWT Authentication
* Driver Availability Status
* Dynamic Fare Calculation
* Ride History
* GPS Tracking
* Online Payment Integration
* Email Notifications
* Driver Ratings & Reviews

---

## 👩‍💻 Author

**Mahaswetha R**

Java Full Stack Developer

GitHub: https://github.com/mahaswetha05