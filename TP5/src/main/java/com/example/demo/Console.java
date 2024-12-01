package com.example.demo;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        IMetier metier = new MetierImpl();
        Scanner scanner = new Scanner(System.in);


        Departement d = new Departement(1,"math22");
        metier.ajouterDepartement(d);

        // Exemple pour ajouter un professeur

        System.out.println("Ajout d'un professeur :");

        Professeur prof = new Professeur();
        prof.setNom("Ahmed");
        prof.setPrenom("Ali");
        prof.setCin("AB123456");
        prof.setAdresse("Casablanca");
        prof.setTelephone("0661122334");
        prof.setEmail("ahmed.ali@example.com");
        prof.setDate_recrutement(new java.util.Date());
        prof.setId_depart(d.getId_depart());
        metier.ajouterProfesseur(prof);
    }
}
