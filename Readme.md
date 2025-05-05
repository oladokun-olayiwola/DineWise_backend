# DineWise Backend

DineWise is a Spring Boot backend service for managing and recommending meal combos based on a user's budget. The backend exposes RESTful APIs for CRUD operations and supports integration with a Flutter frontend.

---

## 📁 Project Structure

```
├── .mvn/                  # Maven Wrapper files
├── src/
│   ├── main/
│   │   ├── java/com/example/dinewise/
│   │   │   ├── config/             # Web configuration (e.g., CORS)
│   │   │   ├── controller/         # REST Controllers
│   │   │   ├── exception/          # Global exception handlers
│   │   │   ├── model/              # JPA Entities
│   │   │   ├── repository/         # Spring Data JPA Repositories
│   │   │   ├── service/            # Business logic
│   │   │   └── DineWiseApplication.java  # Entry point
│   └── resources/
│       ├── application.properties  # Configuration
│       ├── data/
│       │   └── initialize_meals.sql # SQL seed file
├── test/
│   └── java/com/example/dinewise/  # Unit and integration tests
├── pom.xml              # Maven project config
├── .gitignore           # Git ignore rules
├── mvnw, mvnw.cmd       # Maven wrapper
├── meals.db             # Local development database (optional)
└── README.md            # You're here
```

---

## 🚀 Getting Started

### Prerequisites

* Java 17+
* Maven (or use the wrapper)

### Run the Project

```bash
./mvnw spring-boot:run
```

### API Endpoints

| Method | Endpoint               | Description               |
| ------ | ---------------------- | ------------------------- |
| GET    | `/api/recommendations` | Get meals within a budget |
| GET    | `/api/all-meals`       | Get all meals             |
| GET    | `/api/meals/{id}`      | Get meal by ID            |
| POST   | `/api/meals`           | Add a new meal            |
| PATCH  | `/api/meals/{id}`      | Update meal (partial)     |
| DELETE | `/api/meals/{id}`      | Delete meal by ID         |

> All responses are JSON formatted.

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties` to set up DB connection and other settings.

```properties
export DB_URL=jdbc:mysql://localhost:3306/yourdb
export DB_USERNAME=yourusername
export DB_PASSWORD=yourpassword
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## 🌐 CORS Setup

Defined in `WebConfig.java` to allow cross-origin requests from the Flutter frontend:

```java
registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PATCH", "DELETE");
```

---

## 🧪 Running Tests

```bash
./mvnw test
```

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* MySQL (or SQLite for local)
* Maven

---

## 🤝 Contributing

1. Clone the repo
2. Create a new branch `git checkout -b feature/your-feature`
3. Commit your changes
4. Push and open a pull request
