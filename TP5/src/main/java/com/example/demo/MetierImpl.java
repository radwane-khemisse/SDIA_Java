package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private Connection conn = SingletonConnexionDB.getConnexion();

    // Ajouter un professeur
    @Override
    public void ajouterProfesseur(Professeur p) {
        try {
            String sql = "INSERT INTO Professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, id_depart) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getCin());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getTelephone());
            ps.setString(6, p.getEmail());
            ps.setDate(7, new java.sql.Date(p.getDate_recrutement().getTime()));
            ps.setInt(8, p.getId_depart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un professeur
    @Override
    public void supprimerProfesseur(int id) {
        try {
            String sql = "DELETE FROM Professeur WHERE id_prof = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier un professeur
    @Override
    public void modifierProfesseur(Professeur p) {
        try {
            String sql = "UPDATE Professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getCin());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getTelephone());
            ps.setString(6, p.getEmail());
            ps.setDate(7, new java.sql.Date(p.getDate_recrutement().getTime()));
            ps.setInt(8, p.getId_depart());
            ps.setInt(9, p.getId_prof());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rechercher un professeur par ID
    @Override
    public Professeur rechercherProfesseur(int id) {
        Professeur prof = null;
        try {
            String sql = "SELECT * FROM Professeur WHERE id_prof = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prof = new Professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDate_recrutement(rs.getDate("date_recrutement"));
                prof.setId_depart(rs.getInt("id_depart"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    // Lister tous les professeurs
    @Override
    public List<Professeur> listerProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Professeur";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDate_recrutement(rs.getDate("date_recrutement"));
                prof.setId_depart(rs.getInt("id_depart"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    // Affecter un professeur à un département
    @Override
    public void affecterProfesseurADepartement(int idProf, int idDepart) {
        try {
            String sql = "UPDATE Professeur SET id_depart = ? WHERE id_prof = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ps.setInt(2, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Professeur> searchProfesseurs(String keyword) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            // SQL query to search professors based on keyword
            String sql = "SELECT * FROM Professeur p LEFT JOIN Departement d ON p.id_depart = d.id_depart " +
                    "WHERE p.nom LIKE ? OR p.prenom LIKE ? OR p.cin LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Adding wildcards to the search term for LIKE comparison
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern); // Searching in 'nom' (last name)
            ps.setString(2, searchPattern); // Searching in 'prenom' (first name)
            ps.setString(3, searchPattern); // Searching in 'cin' (CIN)

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Process the result set and create Professeur objects
            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId_prof(rs.getInt("id_prof"));
                professeur.setNom(rs.getString("nom"));
                professeur.setPrenom(rs.getString("prenom"));
                professeur.setCin(rs.getString("cin"));
                professeur.setAdresse(rs.getString("adresse"));
                professeur.setTelephone(rs.getString("telephone"));
                professeur.setEmail(rs.getString("email"));
                professeur.setDate_recrutement(rs.getDate("date_recrutement"));
                professeur.setId_depart(rs.getInt("id_depart"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }




    // Ajouter un département
    @Override
    public void ajouterDepartement(Departement d) {
        try {
            String sql = "INSERT INTO Departement (nom) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un département
    @Override
    public void supprimerDepartement(int id) {
        try {
            String sql = "DELETE FROM Departement WHERE id_depart = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier un département
    @Override
    public void modifierDepartement(Departement d) {
        try {
            String sql = "UPDATE Departement SET nom = ? WHERE id_depart = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.setInt(2, d.getId_depart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rechercher un département par ID
    @Override
    public Departement rechercherDepartement(int id) {
        Departement dept = null;
        try {
            String sql = "SELECT * FROM Departement WHERE id_depart = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Departement();
                dept.setId_depart(rs.getInt("id_depart"));
                dept.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    // Lister tous les départements
    @Override
    public List<Departement> listerDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Departement";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Departement dept = new Departement();
                dept.setId_depart(rs.getInt("id_depart"));
                dept.setNom(rs.getString("nom"));
                departements.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    // Lister les professeurs d’un département
    @Override
    public List<Professeur> listerProfesseursParDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Professeur WHERE id_depart = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDate_recrutement(rs.getDate("date_recrutement"));
                prof.setId_depart(rs.getInt("id_depart"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public List<Departement> searchDepartements(String keyword) {
        List<Departement> departements = new ArrayList<>();
        try {
            // SQL query to search departments based on keyword
            String sql = "SELECT * FROM Departement WHERE nom LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Adding wildcards to the search term for LIKE comparison
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern); // Searching in 'nom' (department name)

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Process the result set and create Departement objects
            while (rs.next()) {
                Departement departement = new Departement();
                departement.setId_depart(rs.getInt("id_depart"));
                departement.setNom(rs.getString("nom"));
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

}
