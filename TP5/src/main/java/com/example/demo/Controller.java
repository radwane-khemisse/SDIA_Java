package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.*;

import java.text.SimpleDateFormat;


import java.sql.Date;

import java.util.List;

public class Controller {


    @FXML
    private AnchorPane panelProfesseurs;

    @FXML
    private AnchorPane panelDepartements;

    @FXML
    private TableView<Professeur> tableViewProf;

    @FXML
    private TableColumn<Professeur, Void> colProfActions;

    @FXML
    private TableColumn<Professeur, Integer> colProfId;

    @FXML
    private TableColumn<Professeur, String> colProfNom;

    @FXML
    private TableColumn<Professeur, String> colProfPrenom;

    @FXML
    private TableColumn<Professeur, String> colProfCin;

    @FXML
    private TableColumn<Professeur, String> colProfAdresse;

    @FXML
    private TableColumn<Professeur, String> colProfTelephone;

    @FXML
    private TableColumn<Professeur, String> colProfEmail;

    @FXML
    private TableColumn<Professeur, String> colProfDateRecrutement;

    @FXML
    private TableColumn<Professeur, Integer> colProfIdDepart;

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtEmail;
    @FXML
    private DatePicker dateRecrutement;
    @FXML
    private TextField txtIdDepart;
    @FXML
    private TextField searchField;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Departement> tableViewDepart;
    @FXML
    private TableColumn<Departement, Integer> colDepartId;
    @FXML
    private TableColumn<Departement, String> colDepartNom;
    @FXML
    private TableColumn<Departement, Void> colDepartActions;

    private ObservableList<Departement> departementsList = FXCollections.observableArrayList();

    @FXML
    private TextField txtNomDepart;
    @FXML
    private TextField searchFieldDepart;
    @FXML
    private Button btnSearchDepart;



    // Handles the click event for the "Gestion des Professeurs" button
    @FXML
    private void handleGestionProfesseurs() {
        panelProfesseurs.setVisible(true);
        panelDepartements.setVisible(false);
    }

    // Handles the click event for the "Gestion des Départements" button
    @FXML
    private void handleGestionDepartements() {
        panelProfesseurs.setVisible(false);
        panelDepartements.setVisible(true);
    }

    private ObservableList<Professeur> professeurList;
    private IMetier metier = new MetierImpl(); // Instance of Metier

    @FXML
    public void initialize() {
        // Set up columns
        colProfId.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
        colProfNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colProfPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colProfCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colProfAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colProfTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colProfEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colProfDateRecrutement.setCellValueFactory(new PropertyValueFactory<>("date_recrutement"));
        colProfIdDepart.setCellValueFactory(new PropertyValueFactory<>("id_depart"));
        setupActionsColumn();
        loadProfesseurs();
        btnSearch.setOnAction(event -> handleSearch());

        // Set up the columns for the TableView
        colDepartId.setCellValueFactory(new PropertyValueFactory<>("id_depart"));
        colDepartNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        // Setup the Actions column
        setupActionsDepart();
        loadDepartements();
        btnSearchDepart.setOnAction(event -> handleSearchDepart());


    }

    private void setupActionsColumn() {
        colProfActions.setCellFactory(param -> new TableCell<Professeur, Void>() {
            private final Button editBtn = new Button("Modifier");
            private final Button deleteBtn = new Button("Supprimer");
            private final Button assignBtn = new Button("Assigner");

            {
                // Edit button action
                editBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleEdit(professeur);
                    }
                });

                // Delete button action
                deleteBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleDelete(professeur);
                    }
                });

                // Assign button action
                assignBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleAssign(professeur);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null); // Empty row, remove buttons
                } else {
                    HBox hbox = new HBox(10, editBtn, deleteBtn, assignBtn);
                    setGraphic(hbox); // Add buttons in row
                }
            }
        });
    }

    @FXML
    private void handleEdit(Professeur professeur) {
        Dialog<Professeur> dialog = new Dialog<>();
        dialog.setTitle("Modifier un professeur");
        dialog.setHeaderText("Modifier les informations du professeur: "+ professeur.getNom());

        // Define the "Save" and "Cancel" buttons for the dialog
        ButtonType saveButtonType = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Create the grid pane for layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        // Create the text fields for each input
        TextField nom = new TextField(professeur.getNom());
        TextField prenom = new TextField(professeur.getPrenom());
        TextField cin = new TextField(professeur.getCin());
        TextField adresse = new TextField(professeur.getAdresse());
        TextField telephone = new TextField(professeur.getTelephone());
        TextField email = new TextField(professeur.getEmail());
        TextField idDepart = new TextField(String.valueOf(professeur.getId_depart())); // For department

        // Add the labels and text fields to the grid
        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(cin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(adresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(email, 1, 5);
        grid.add(new Label("Département:"), 0, 6);  // Label for department
        grid.add(idDepart, 1, 6);  // TextField for department

        // Set the grid as the content of the dialog
        dialog.getDialogPane().setContent(grid);

        // Define what happens when the user clicks "Save"
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                // Update the professeur object with new values
                professeur.setNom(nom.getText());
                professeur.setPrenom(prenom.getText());
                professeur.setCin(cin.getText());
                professeur.setAdresse(adresse.getText());
                professeur.setTelephone(telephone.getText());
                professeur.setEmail(email.getText());
                professeur.setId_depart(Integer.parseInt(idDepart.getText())); // Update department
                return professeur;
            }
            return null;
        });

        // Show the dialog and update the professor if the user clicks "Save"
        dialog.showAndWait().ifPresent(updatedProfesseur -> {
            metier.modifierProfesseur(updatedProfesseur); // Update the professor in the database
            loadProfesseurs(); // Refresh the table to show the updated professor
        });
    }


    @FXML
    private void handleDelete(Professeur professeur) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le professeur");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce professeur ?");

        // Show the alert and handle the user's response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // If the user confirms, delete the professor
                metier.supprimerProfesseur(professeur.getId_prof()); // Assuming the method to delete is called 'supprimerProfesseur'
                loadProfesseurs(); // Refresh the table to reflect the changes
            }
        });
    }

    @FXML
    private void handleAssign(Professeur professeur) {
        // Create a dialog for assigning a department to the professor
        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle("Assigner un département");
        dialog.setHeaderText("Assigner un département à " + professeur.getNom() + " " + professeur.getPrenom());

        // Define buttons for the dialog
        ButtonType assignButtonType = new ButtonType("Assigner", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        // Create a ComboBox for selecting the department
        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.setItems(FXCollections.observableArrayList(
                metier.listerDepartements().stream()  // Assuming you have a method `listerDepartements()` that fetches the list of departments
                        .map(Departement::getNom)       // Get department names
                        .toList()
        ));
        departmentComboBox.setPromptText("Sélectionnez un département");

        // Set up the grid layout for the dialog
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Département:"), 0, 0);
        grid.add(departmentComboBox, 1, 0);
        dialog.getDialogPane().setContent(grid);

        // Set the result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == assignButtonType) {
                int selectedIndex = departmentComboBox.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    // Get the department ID by its index
                    return metier.listerDepartements().get(selectedIndex).getId_depart();
                }
            }
            return null;
        });

        // Show the dialog and handle the result
        dialog.showAndWait().ifPresent(departmentId -> {
            // Use the predefined method to assign the professor to the selected department
            metier.affecterProfesseurADepartement(professeur.getId_prof(), departmentId);

            // Reload the list of professors to update the table view
            loadProfesseurs();

            // Show a success alert
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Succès");
            success.setHeaderText(null);
            success.setContentText("Le professeur a été assigné au département avec succès !");
            success.show();
        });
    }



    private void loadProfesseurs() {
        List<Professeur> professeurs = metier.listerProfesseurs();
        professeurList = FXCollections.observableArrayList(professeurs);
        tableViewProf.setItems(professeurList);
    }

    @FXML
    private void ajouterProfesseur() {
        Date dateRecrutementSQL = Date.valueOf(dateRecrutement.getValue());

        Professeur p = new Professeur(0,txtNom.getText(), txtPrenom.getText(), txtCin.getText(),
                txtAdresse.getText(), txtTelephone.getText(),
                txtEmail.getText(), dateRecrutementSQL, Integer.parseInt(txtIdDepart.getText()));
        metier.ajouterProfesseur(p);
        loadProfesseurs(); // Refresh table
        clearFormProf();
        // Show a confirmation dialog with the professor's name
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Succès");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Professeur " + p.getNom() + " " + p.getPrenom() + " a été ajouté avec succès !");
        successAlert.showAndWait();
    }

    @FXML
    private void supprimerProfesseur() {
        Professeur selected = tableViewProf.getSelectionModel().getSelectedItem();
        if (selected != null) {
            metier.supprimerProfesseur(selected.getId_prof());
            loadProfesseurs(); // Refresh table
        }
    }
    @FXML
    private void clearFormProf() {
        txtNom.clear();
        txtPrenom.clear();
        txtCin.clear();
        txtAdresse.clear();
        txtTelephone.clear();
        txtEmail.clear();
        dateRecrutement.setValue(null); // Clear the DatePicker
        txtIdDepart.clear(); // Clear the department field
    }
    @FXML
    private void handleSearch() {
        String keyword = searchField.getText().trim(); // Get the keyword and trim any extra spaces

        if (keyword != null && !keyword.isEmpty()) {
            // If the search keyword is not empty, search for professors
            List<Professeur> professeurs = metier.searchProfesseurs(keyword);
            if (professeurs.isEmpty()) {
                // If no professors are found, show an alert
                showAlert("No professors found for the search keyword.");
            } else {
                // Update the TableView with the found professors
                tableViewProf.setItems(FXCollections.observableArrayList(professeurs));
            }
        } else {
            // If the keyword is empty, load all professors
            loadProfesseurs();
        }

        // Refresh the TableView to display updated data
        tableViewProf.refresh();
    }
    // Method to show alerts
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Search Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    // deparement methods
    // Setup Actions column for the Departement TableView
    public void setupActionsDepart() {
        colDepartActions.setCellFactory(param -> new TableCell<Departement, Void>() {
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");
            private final Button afficherProfesseurParDepartementButton = new Button("Afficher les professeurs");

            {
                // Edit button action
                editButton.setOnAction(event -> {
                    Departement departement = getTableView().getItems().get(getIndex());
                    if (departement != null) {
                        handleEdit(departement);
                    }
                });

                // Delete button action
                deleteButton.setOnAction(event -> {
                    Departement departement = getTableView().getItems().get(getIndex());
                    if (departement != null) {
                        handleDelete(departement);
                    }
                });
                // afficher professeur button
                afficherProfesseurParDepartementButton.setOnAction(event -> {
                    Departement departement = getTableView().getItems().get(getIndex());
                    if (departement != null) {
                        handleAfficherProfesseur(departement);
                    }
                });

            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);  // Clear the cell if it's empty
                } else {
                    // Set the buttons into the TableCell
                    HBox hBox = new HBox(10);  // Use a horizontal box to layout the buttons
                    hBox.getChildren().addAll(editButton, deleteButton,afficherProfesseurParDepartementButton);  // Add both buttons to the box
                    setGraphic(hBox);  // Set the horizontal box as the graphic for the TableCell
                }
            }
        });
    }

    // Load data from the business logic service (listerDepartements method)
    private void loadDepartements() {
        List<Departement> departements = metier.listerDepartements();
        departementsList.setAll(departements);
        tableViewDepart.setItems(departementsList);
    }

    @FXML
    private void handleEdit(Departement departement) {
        // Create a dialog for editing the department
        Dialog<Departement> dialog = new Dialog<>();
        dialog.setTitle("Modifier un département");
        dialog.setHeaderText("Modifier le département: " + departement.getNom());

        // Define the "Save" and "Cancel" buttons for the dialog
        ButtonType saveButtonType = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Create the grid pane for layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        // Create the text field for department name
        TextField nomField = new TextField(departement.getNom());

        // Add the label and text field for department name to the grid
        grid.add(new Label("Nom du département:"), 0, 0);
        grid.add(nomField, 1, 0);

        // Set the grid as the content of the dialog
        dialog.getDialogPane().setContent(grid);

        // Define what happens when the user clicks "Save"
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                // Update the department object with the new name
                departement.setNom(nomField.getText());
                return departement;
            }
            return null;
        });

        // Show the dialog and update the department if the user clicks "Save"
        dialog.showAndWait().ifPresent(updatedDepartement -> {
            metier.modifierDepartement(updatedDepartement); // Update the department in the database
            loadDepartements(); // Refresh the table to show the updated department
        });
    }


    @FXML
    private void handleDelete(Departement departement) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le département");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer le département : " + departement.getNom() + "?");

        // Show the alert and handle the user's response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // If the user confirms, delete the department
                metier.supprimerDepartement(departement.getId_depart()); // Assuming the method to delete is called 'supprimerDepartement'
                loadDepartements(); // Refresh the table to reflect the changes
            }
        });
    }


    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define the date format

    private void handleAfficherProfesseur(Departement departement) {
        // Create a dialog to display professors
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Professeurs du Département");
        dialog.setHeaderText("Liste des professeurs du département: " + departement.getNom());

        // Create a TableView to display professors
        TableView<Professeur> professeursTable = new TableView<>();

        // Define columns for the TableView
        TableColumn<Professeur, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_prof"));

        TableColumn<Professeur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Professeur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Professeur, String> cinCol = new TableColumn<>("CIN");
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));

        TableColumn<Professeur, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        TableColumn<Professeur, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Professeur, String> telephoneCol = new TableColumn<>("Téléphone");
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        TableColumn<Professeur, String> dateCol = new TableColumn<>("Date Recrutement");
        dateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(dateFormat.format(cellData.getValue().getDate_recrutement())));

        // Add all columns to the table
        professeursTable.getColumns().addAll(
                idCol, nomCol, prenomCol, cinCol, adresseCol, emailCol, telephoneCol, dateCol
        );

        // Populate the table with data
        professeursTable.setItems(
                FXCollections.observableArrayList(
                        metier.listerProfesseursParDepartement(departement.getId_depart())
                )
        );

        // Set table dimensions
        professeursTable.setMinWidth(600);
        professeursTable.setMinHeight(400);

        // Add table to dialog content
        VBox content = new VBox(10);
        content.getChildren().add(professeursTable);
        dialog.getDialogPane().setContent(content);

        // Add a close button to the dialog
        ButtonType closeButton = new ButtonType("Fermer", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        // Show the dialog and wait for user interaction
        dialog.showAndWait();
    }




    @FXML
    private void ajouterDepartement() {
        // Check if the department name is provided
        String departNom = txtNomDepart.getText().trim();
        if (departNom.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Nom du département vide");
            alert.setContentText("Veuillez saisir un nom pour le département.");
            alert.showAndWait();
            return; // Exit the method if input is empty
        }

        // Create a new Departement instance
        Departement d = new Departement(0, departNom);

        // Add the new department using the 'metier' service (assuming it is properly injected or initialized)
        metier.ajouterDepartement(d);
        clearFormDepart();
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Succès");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Département '" + d.getNom() + "' a été ajouté avec succès !");
        successAlert.showAndWait();

        // Refresh the table view by loading the updated list of departments
        loadDepartements();  // Assuming 'loadDepartements' method is correctly implemented to reload the table view

        // Show a confirmation dialog with the department's name

    }
    @FXML
    private void handleSearchDepart() {
            String keyword = searchFieldDepart.getText().trim(); // Get the keyword and trim any extra spaces

            if (keyword != null && !keyword.isEmpty()) {
                // If the search keyword is not empty, search for professors
                List<Departement> departements = metier.searchDepartements(keyword);
                if (departements.isEmpty()) {
                    // If no professors are found, show an alert
                    showAlert("No departement found for the search keyword.");
                } else {
                    // Update the TableView with the found professors
                    tableViewDepart.setItems(FXCollections.observableArrayList(departements));
                }
            } else {
                // If the keyword is empty, load all professors
                loadDepartements();
            }

            // Refresh the TableView to display updated data
            tableViewDepart.refresh();


    }

    @FXML
    private void clearFormDepart() {
        txtNomDepart.clear();
    }



}
