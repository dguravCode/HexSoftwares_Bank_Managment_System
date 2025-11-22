# Bank Management System

A comprehensive desktop-based banking application built with Java Swing and MySQL. This system provides a complete ATM-like interface with secure user authentication, account management, and financial transactions.

## Features

### User Authentication
- **Login System**: Secure PIN-based authentication via `Login`
- **Account Registration**: Multi-step signup process with personal and financial details

### Account Management
- **Three-Step Registration**:
  - `SignupOne` - Personal details (name, DOB, gender, marital status, address)
  - `SignupTwo` - Additional information (religion, category, income, education, PAN, Aadhar)
  - `SignupThree` - Account setup (account type, card generation, PIN assignment, service selection)

### Financial Transactions
- **Withdrawal**: `withdrawl` - Process cash withdrawals
- **Deposit**: `Deposite` - Handle cash deposits
- **Fast Cash**: `FastCash` - Quick predefined withdrawal amounts (Rs. 100, 500, 1000, 5000, 10000)
- **Balance Enquiry**: `BalanceEnquiry` - Check current account balance
- **Mini Statement**: `MiniStatement` - View recent transaction history

### Additional Features
- **PIN Change**: `PinChange` - Secure PIN modification
- **Transaction History**: `Transactions` - Complete transaction records

## Technology Stack

- **Language**: Java
- **GUI Framework**: Swing (javax.swing)
- **Database**: MySQL
- **JDBC Driver**: MySQL Connector Java 8.0.28
- **Calendar Component**: JCalendar (jcalendar-tz-1.3.3-4.jar)
- **Build Tool**: Apache Ant
- **IDE**: NetBeans

## Database Connection

Database connectivity is managed through `conn` class, which establishes JDBC connections to the MySQL database `bankmanagmentsystem`.

## java file Structure

```
src/bank/managment/system/
├── Login.java
├── SignupOne.java
├── SignupTwo.java
├── SignupThree.java
├── conn.java
├── BalanceEnquiry.java
├── Deposite.java
├── FastCash.java
├── withdrawl.java
├── MiniStatement.java
├── Transactions.java
└── PinChange.java
```

## Building and Running

Build the project using Ant:

```sh
ant jar
```

Run the application:

```sh
java -jar dist/Bank_Managment_System.jar
```

Or execute directly:

```sh
ant run
```

## Requirements

- Java 8 or higher
- MySQL Server
- Database: `bankmanagmentsystem`
- MySQL user credentials configured in `conn.java`

## Notes

- The application uses a graphical interface for all banking operations
- All financial transactions are recorded in the database
- PIN-based security ensures user authentication
- Card numbers and PINs are auto-generated during account creation
