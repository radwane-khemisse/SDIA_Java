package com.example.demo;

public class Departement {
    private int id_depart;
    private String nom;

    public Departement(int id_depart, String nom) {
        this.id_depart = id_depart;
        this.nom = nom;
    }

    public Departement() {

    }

    // Getters et Setters
    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
