# Java Project - Object-Oriented Programming: Inheritance, Abstract Classes, and Interfaces

## Overview
In this project, we implement four main exercises to practice object-oriented programming (OOP) concepts in Java. Each exercise focuses on key OOP principles, including inheritance, method overriding, abstract classes, and interfaces.

### Table of Contents
- [Exercise 1: Library Management System](#exercise-1-library-management-system)
- [Exercise 2: Employee Salary Management](#exercise-2-employee-salary-management)
- [Exercise 3: Order Management System](#exercise-3-order-management-system)
- [Exercise 4: Product Collection Management](#exercise-4-product-collection-management)

## Exercise 1: Library Management System
In this first exercise, we develop a simple library management system to manage library members and books. Key features include:
1. **Classes**:
    - `Personne` (base class with attributes like name, email, etc.)
    - `Adherent` (inherits `Personne`, adds membership number)
    - `Auteur` (inherits `Personne`, adds author number)
    - `Livre` (represents books, includes ISBN and author details)
2. **Main Application**:
    - Create an instance of `Adherent` and `Livre` and display their details.

## Exercise 2: Employee Salary Management
This exercise models an application for managing employee salaries in a development company, focusing on engineers and managers. Key features include:
1. **Abstract Class**:
    - `Employe` (base class with abstract method `calculerSalaire` and attributes such as name, salary, etc.)
2. **Classes**:
    - `Ingenieur` (inherits `Employe`, adds specialization, salary with a 15% increase)
    - `Manager` (inherits `Employe`, adds department, salary with a 20% increase)
3. **Main Application**:
    - Instantiate `Ingenieur` and `Manager`, calculate their salaries, and display their details.

## Exercise 3: Order Management System
This exercise focuses on managing orders, categories, and products for a company selling computers. Key features include:
1. **Classes**:
    - `Ordinateur` (attributes like name, brand, stock, price calculation by quantity)
    - `Categorie` (list of computers, includes add, remove, and search by price methods)
    - `Commande` (attributes like reference, client, order date, and status)
    - `LigneCommande` (includes quantity, associated order, and ordered computer)
    - `Client` (stores personal details and a list of orders)
2. **Main Application**:
    - Create instances of `Ordinateur`, `Categorie`, `Client`, and `Commande` to test the order and product management system.

## Exercise 4: Product Collection Management
In this exercise, we manage a collection of products using lists and interfaces to simulate basic product operations. Key features include:
1. **Classes**:
    - `Produit` (product attributes such as ID, name, brand, etc.)
    - `IMetierProduit` (interface with methods like `add`, `getAll`, `findByNom`, `findById`, and `delete`)
    - `MetierProduitImpl` (implements `IMetierProduit`, manages product list)
2. **Main Application**:
    - A console-based menu system that allows users to add, list, search, retrieve by ID, delete products, or exit.

---

## Setup and Execution
1. **Clone the repository**: Clone this repository to your local machine.
2. **Compile and Run**: Compile each exercise's `Main` class to run the corresponding application.
3. **Usage**:
    - Each application is designed to test the specific functionalities outlined in each exercise. Run the applications sequentially to explore inheritance, abstract classes, and interface implementations in Java.

---

## About
This project was developed as part of a practical assignment in Java OOP, with exercises covering essential concepts such as inheritance, method overriding, polymorphism, abstract classes, and interface implementations.
