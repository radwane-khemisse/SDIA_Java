# School Management System

## Introduction

The **School Management System** is a JavaFX-based application that facilitates the management of professors and departments within an educational institution. The system allows users to manage professors' information, assign professors to specific departments, add new departments, search for records, and perform various CRUD (Create, Read, Update, Delete) operations. This project aims to simplify administrative tasks by providing a user-friendly interface for efficiently managing school data.

## Features

- **Gestion des Professeurs (Professor Management):**
    - Add, edit, delete, and search professors.
    - Assign professors to departments.
    - View professors based on department.

- **Gestion des Départements (Department Management):**
    - Add, edit, and delete departments.
    - View and manage departments with the list of associated professors.

- **Search Functionality:**
    - Search for professors and departments using keywords.

## Project Structure

The project consists of several key components:

1. **UI Components**: The application uses JavaFX for the graphical user interface (GUI). Screens are divided into two main panels: one for managing professors and the other for managing departments.
2. **Business Logic**: The `IMetier` interface defines methods for performing CRUD operations, while `MetierImpl` provides the implementation.
3. **Database Connection**: The application uses a MySQL database to store information about professors and departments.
4. **Screenshots**: Screenshots of different scenes in the application can be found in the `screenshots` folder to provide visual representations of the functionality.

## Screenshots

The following screenshots illustrate the different scenes of the application:

1. **Afficher Professeur par Département**  
   ![Afficher Professeur par Département](screenshots/afficherProfesseurParDepartemetn.png)

2. **Ajout Département**  
   ![Ajout Département](screenshots/ajoutDepartement.png)

3. **Ajout Professeur**  
   ![Ajout Professeur](screenshots/ajoutProfesseur.png)

4. **Assigner Département**  
   ![Assigner Département](screenshots/assignerDepartment.png)

5. **Gestion des Départements**  
   ![Gestion des Départements](screenshots/gestionDesDeaprtement.png)

6. **Modifier Professeur**  
   ![Modifier Professeur](screenshots/ModifierProfesseur.png)

7. **Search by Keyword for Department**  
   ![Search by Keyword for Department](screenshots/searchByKeywoardDepartement.png)

8. **Search by Keyword for Professor**  
   ![Search by Keyword for Professor](screenshots/searchProfByKeywoard.png)

9. **Supprimer Département**  
   ![Supprimer Département](screenshots/SupprimerDepartement.png)

10. **Supprimer Professeur**  
    ![Supprimer Professeur](screenshots/supprimerProfesseur.png)

## Conclusion

The **School Management System** provides a powerful and intuitive interface for managing professors and departments in a school setting. By allowing users to quickly add, edit, and delete records, it significantly improves the efficiency of administrative tasks. The system also includes robust search functionality, making it easy to find specific records based on keywords.

This project serves as a good example of how JavaFX and a simple database can be used to build practical applications for educational institutions or other organizations.
