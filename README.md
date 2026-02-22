# SUPPORT-TICKET-MANAGEMENT-SYSTEM-CLGProject-
A JSP with Servlet project to manage view edit and delete users ticket for any issue
This is a simple web-based Support Ticket Management System developed using Java Servlets, JSP, JDBC, and MySQL.

The purpose of this project is to manage support tickets where users can create, view, update, delete, and search tickets. It demonstrates basic CRUD operations and follows the MVC architecture.

Project Description

The system allows users to:

Add new support tickets

View all submitted tickets

Update ticket details

Delete tickets

Search tickets by username or status

All ticket data is stored in a MySQL database and accessed using JDBC.

Technologies Used

Java (JDK 1.8)

JSP (Java Server Pages)

Servlets

JDBC

MySQL

Apache Tomcat

Eclipse IDE

HTML & Basic CSS

System Architecture

The project follows the MVC (Model-View-Controller) architecture:

Model → Ticket.java

View → JSP Pages

Controller → Servlets

Data Access → TicketDAO using JDBC

Flow of execution:

User → JSP → Servlet → DAO → Database

Database Details

Database Name: supportdb
Table Name: tickets

Columns:

ticketid (INT, Primary Key, Auto Increment)

username (VARCHAR)

issuedescription (VARCHAR)

priority (VARCHAR)

status (VARCHAR)

How to Run the Project

Install MySQL and create the database:

CREATE DATABASE supportdb;

Create the tickets table:

CREATE TABLE tickets (
    ticketid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    issuedescription VARCHAR(255),
    priority VARCHAR(50),
    status VARCHAR(50)
);

Update database credentials in DBConnection.java.

Deploy the project on Apache Tomcat.

Open in browser:

http://localhost:8080/SupportTicketSystem/addTicket.jsp
Features

Basic CRUD operations

Search functionality

Clean MVC structure

JDBC connectivity

Simple user interface

Conclusion

This project demonstrates the development of a basic Java web application using Servlets, JSP, and MySQL. It provides a practical understanding of MVC architecture and database connectivity in web development.
