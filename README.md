# NorthwindREST

Java Spring Boot REST API project: Northwind API

## Table of Contents
1. [Introduction](#introduction)
2. [Installation Requirements](#installation)
3. [Instructions](#instructions)
4. [Endpoints]
5. [Exception Handling]
6. [Future Direction](#future)

## Introduction <a name ="instroduction"><a/>

The idea behind this project was to create a REST API through connecting the Northwind database annd utilising APIs in order to create a GET retrieval system that would allow users to search for a retrieve specific data.
In this context, the API was designed for a shipping salesperson, who should be able to see the products in the system, orders, and a general overview of the system.

## Installation Requirements<a name="installation"><a/>

This project runs with JDK 17, and needs this to operate if downloaded via a cloned repository or downloaded from a zip and installed.
This project also uses Spring Boot. Any dependencies should be checked in the pom file as well.
Connection to the Northwind DB is also required.

## Endpoints
 
 The user can access all tables with the ability to search for a matching ID or the  name fields of each object with a full return outside of:

### Employee

Its endpoints include
- /ID, where it looks for a record which has the same matching ID in the system
- /employees/ where firstName and lastName are parameters and will return a record with either or both are inputted, otherwise it returns all records from that table.

It uses a DTO which removes the notes, reports to and photos fields from the Entity pulled from the database.

### Orders

Its endpoints include
- /ID, where it looks for a record which has the same matching ID in the system
- and a /orders/ with the parameters of orderDate, requiredDate and shippedDate, which use String as an optional parameter for all three. By any of these three as a query, it should return a record with the matching date in the system.

The DTO for this table changes the Category and Employee ID to ones that use the name fields from their respective tables.

### Products

Its endpoints include
- /ID, where it looks for a record which has the same matching ID in the system
-Supplier and Category name, where

It uses a DTO which mainly changes its category and supplier id to the names for each supplier and category in their respective tables.



## Exception Handling

This project utilises exception handling in the form of creating an Error Details class (where the error type, message and details can be stored and outputted. This is then managed by a GlobalExceptionHandler, which checks for the exceptiona used and helps create an error details object using the data sent from the API.

The project currently has a DateTimeParse Exception for when an incorrect date format for the OrderController's date/time search is used, and a basic ResourceNotFound exception for when an ID not within Northwind is called.



## Future Direction 

A future implementation would've been properly adding the "reports to" column for the EmployeeDTO, and to display it using the name of the person, as complications prevented this from being introduced.

Swagger UI's implementation would've been a further implementation.

A proper unit testing suit is a future consideration, as to test the functionality of the methods used in both the DTOs and the controllers using Mocking and parameterised tests.

Another improvement would be the expansion of error handling, especially with String based calls such as with searching for names in the system (such as employee names, suppliers and category names) for when there's a resource not found.

SOLID principles should've also had been implemented to organise the system's structure.
