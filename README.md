# solidPrinciples
**Order Processing System**

This is a requirement for Lab Assignment 3 in Software Engineering 2.

## Overview
This project is a Java-based demonstration of the **SOLID principles** of Object-Oriented Programming (OOP). It simulates an order processing system, taking a monolithic design and refactoring it into a highly modular, maintainable, and loosely coupled architecture.

## Project Structure

The application has been decomposed into specific interfaces and classes to ensure each component has a clear, singular purpose:

- **`Order`**: A simple data class representing the details of an order (customer name, address, price, quantity).
- **`OrderRepository` & `DatabaseOrderRepository`**: Abstraction and concrete implementation for persisting orders.
- **`InvoiceGenerator` & `PdfInvoiceGenerator`**: Abstraction and concrete implementation for generating order invoices.
- **`NotificationSender` & `EmailNotificationSender`**: Abstraction and concrete implementation for dispatching customer notifications.
- **`OrderProcessor`**: The orchestrator class that coordinates the repository, invoice generation, and notifications using dependency injection.
- **`OrderTest`**: The main entry point demonstrating how to configure and execute an order process.

## SOLID Principles Applied

This project adheres to the five SOLID principles:

1. **Single Responsibility Principle (SRP)**
   Instead of a single "fat" class handling logic, database operations, emails, and PDFs, each class now has only one reason to change. `OrderProcessor` handles orchestration, `PdfInvoiceGenerator` handles PDFs, etc.

2. **Open/Closed Principle (OCP)**
   The system is open for extension but closed for modification. If you need to add SMS notifications, you can simply create an `SmsNotificationSender` implementing `NotificationSender` without altering the `OrderProcessor`.

3. **Liskov Substitution Principle (LSP)**
   The `OrderProcessor` works with abstractions (`OrderRepository`, `InvoiceGenerator`, `NotificationSender`). Any subclass or implementing class can be substituted without breaking the application logic. 

4. **Interface Segregation Principle (ISP)**
   Instead of one large `OrderAction` interface forcing unused methods onto clients, the behaviors are split into focused interfaces (`InvoiceGenerator`, `NotificationSender`, etc.). Classes only implement what they actually use.

5. **Dependency Inversion Principle (DIP)**
   High-level modules (`OrderProcessor`) do not depend on low-level modules (`EmailNotificationSender`, `DatabaseOrderRepository`). Both depend on abstractions. Dependencies are injected via the constructor, allowing for easy testing and swapping of implementations.

## How to Run

1. Ensure you have the Java JDK installed.
2. Compile the Java files in the `labAssignment5` package.
3. Run the `OrderTest` class.

**Expected Output:**
```text
Order total: $20.0
Order placed for John Doe at 123 Main St
Invoice generated: order_123.pdf
Email notification sent to: johndoe@example.com
```

## UML Diagram
![alt text](https://github.com/ramdcrz/solidPrinciples/blob/main/solidPrinciples_UML.png)