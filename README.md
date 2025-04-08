# Expense Tracker - Spring Boot Application

## 📌 Overview
This is a simple Expense Tracker REST API built with **Spring Boot** that allows users to:
- Create users
- Manage expense categories
- Track expenses per user

## 🛠 Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Web
- H2 / MySQL
- Lombok

## 🗃 Folder Structure
```
expense-tracker/
├── src/main/java/com/example/expensetracker/
│   ├── controllers/         # REST Controllers
│   ├── entities/            # JPA Entities
│   ├── repositories/        # Repositories
│   ├── services/            # Business Logic
│   ├── dtos/                # Data Transfer Objects
│   ├── ExpenseTrackerApplication.java  # Main class
├── src/main/resources/
│   └── application.properties
├── pom.xml
```

## 📬 API Endpoints

### 👤 User
| Method | Endpoint          | Description       |
|--------|-------------------|-------------------|
| POST   | `/api/users`      | Create a user     |
| GET    | `/api/users/{id}` | Get user by ID    |

### 📂 Category
| Method | Endpoint                | Description                |
|--------|-------------------------|----------------------------|
| POST   | `/api/categories`       | Create a category          |
| POST   | `/api/categories/expense` | Create an expense category |
| GET    | `/api/categories`       | List all categories        |

### 💸 Expense
| Method | Endpoint                  | Description                |
|--------|---------------------------|----------------------------|
| POST   | `/api/expenses`           | Add a new expense          |
| GET    | `/api/expenses/user/{id}` | Get all expenses for user  |
| GET    | `/api/expenses/{id}`      | Get a single expense by ID |
| DELETE | `/api/expenses/{id}`      | Delete an expense          |
| PUT    | `/api/expenses/{id}`      | Update an expense          |

## ⚙️ Setup Instructions
1. Clone the repository
2. Import into **Eclipse/IntelliJ** as a Maven project
3. Configure `application.properties` with DB settings
4. Run `ExpenseTrackerApplication.java`
5. Use **Postman** to test the APIs

## 🔐 Future Improvements
- Add JWT-based authentication
- Monthly reports and charts
- Email notifications
- Frontend (React/Angular)

## 🧑‍💻 Author
Sachin Mehra

---
Feel free to fork and contribute 🤝

