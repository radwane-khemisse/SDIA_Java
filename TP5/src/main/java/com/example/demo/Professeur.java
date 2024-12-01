package com.example.demo;

import java.util.Date;

public class Professeur {
    private int id_prof;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private String email;
    private Date date_recrutement;
    private int id_depart;

    public Professeur(int id_prof, String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement, int id_depart) {
        this.id_prof = id_prof;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.date_recrutement = date_recrutement;
        this.id_depart = id_depart;
    }

    public Professeur() {

    }

    public int getId_prof() {
        return id_prof;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

}
