package com.example.cabinet.Metier;

import com.example.cabinet.Model.Consultation;
import com.example.cabinet.Model.Medecin;
import com.example.cabinet.Model.Patient;
import com.example.cabinet.Singleton.SingletonConnexionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CabinetMetierImpl implements ICabinetMetier {
    Connection conn=  SingletonConnexionDb.getConnexion();
    @Override
    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql= "select * from patient";
        try {
            Statement st= conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Patient p = new Patient();
                p.setId_patient(rs.getInt("id_patient"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDate_naissance(rs.getDate("date_naissance"));
                patients.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public List<Patient> getPatientsKey(String keywoard) {
        List<Patient> patients = new ArrayList<>();
        String sql= "select * from patient where nom LIKE ? OR prenom LIKE ? OR cin LIKE ? OR telephone LIKE ? OR email LIKE ?";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            String likeKeywoard= "%"+keywoard+"%";
            ps.setString(1, likeKeywoard);
            ps.setString(2, likeKeywoard);
            ps.setString(3, likeKeywoard);
            ps.setString(4, likeKeywoard);
            ps.setString(5, likeKeywoard);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient p = new Patient();
                p.setId_patient(rs.getInt("id_patient"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDate_naissance(rs.getDate("date_naissance"));
                patients.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public void addPatient(Patient patient) {
        String sql= "insert into patient (nom,prenom,cin,telephone,email,date_naissance) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getCin());
            ps.setString(4, patient.getTelephone());
            ps.setString(5, patient.getEmail());
            ps.setDate(6, new Date(patient.getDate_naissance().getTime()));
            ps.executeUpdate();
            System.out.println("patient  " + patient.getNom() + " added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePatient(int id_patient) {
        String sql= "delete from patient where id_patient =?";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id_patient);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consultation> getConsultsOfPatient(int id_patient) {
        List<Consultation> consults = new ArrayList<>();
        String sql= "select * from consultation where id_patient =?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id_patient);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id_consultation"));
                c.setDate_consultation(rs.getDate("date_consultation"));
                c.setId_patient(rs.getInt("id_patient"));
                c.setId_medecin(rs.getInt("id_medecin"));
                consults.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consults;
    }

    @Override
    public void addMedecin(Medecin medecin) {
        String sql= "insert into medecin (nom,prenom,email,tel) values(?,?,?,?)";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getEmail());
            ps.setString(4, medecin.getTel());
            ps.executeUpdate();
            System.out.println("medecin " + medecin.getNom() + " added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Medecin> getMedecins() {
        List<Medecin> medecins = new ArrayList<>();
        String sql= "select * from medecin";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Medecin m = new Medecin();
                m.setId_medecin(rs.getInt("id_medecin"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                m.setEmail(rs.getString("email"));
                m.setTel(rs.getString("tel"));
                medecins.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return medecins;
    }

    @Override
    public void deleteMedecin(int id_medecin) {
        String sql= "delete from medecin where id_medecin =?";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id_medecin);
            ps.executeUpdate();
            System.out.println("medecin " + id_medecin + " deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consultation> getConsultsOfMedecin(int id_medecin) {
        List<Consultation> consults = new ArrayList<>();
        String sql= "select * from consultation where id_medecin =?";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id_medecin);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id_consultation"));
                c.setDate_consultation(rs.getDate("date_consultation"));
                c.setId_patient(rs.getInt("id_patient"));
                c.setId_medecin(rs.getInt("id_medecin"));
                consults.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return consults;
    }

    @Override
    public void addConsultation(Consultation consult) {
        String sql="insert into consultation (date_consultation,id_patient,id_medecin) values(?,?,?)";
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setDate(1, new Date(consult.getDate_consultation().getTime()));
            ps.setInt(2, consult.getId_patient());
            ps.setInt(3, consult.getId_medecin());
            ps.executeUpdate();
            System.out.println("consultation in date " + consult.getDate_consultation() + " added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consultation> getConsults() {
        List<Consultation> consults = new ArrayList<>();
        String sql= "select * from consultation";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("id_consultation"));
                c.setDate_consultation(rs.getDate("date_consultation"));
                c.setId_patient(rs.getInt("id_patient"));
                c.setId_medecin(rs.getInt("id_medecin"));
                consults.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consults;
    }

    @Override
    public void deleteConsultation(int id_consultation) {
        String sql= "delete from consultation where id_consultation =?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id_consultation);
            ps.executeUpdate();
            System.out.println("consultation in date " + id_consultation + " deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
