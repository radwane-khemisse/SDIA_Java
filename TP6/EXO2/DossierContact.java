package EXO2;

import java.io.*;
import java.util.*;

public class DossierContact {
    private Map<String, String> contacts;

    public DossierContact() {
        contacts = new HashMap<>();
        chargerContacts();
    }

    // Charger les contacts depuis les fichiers
    private void chargerContacts() {
        File dossier = new File("contacts");
        if (!dossier.exists()) {
            dossier.mkdir();  // Crée le répertoire s'il n'existe pas
            return;
        }

        File[] fichiers = dossier.listFiles();
        if (fichiers != null) {
            for (File fichier : fichiers) {
                String nom = fichier.getName();
                try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                    String numero = reader.readLine();
                    contacts.put(nom, numero);
                } catch (IOException e) {
                    System.out.println("Erreur lors de la lecture du fichier : " + fichier.getName());
                }
            }
        }
    }

    // Sauvegarder les contacts dans des fichiers
    public void sauvegarderContacts() {
        File dossier = new File("contacts");
        if (!dossier.exists()) {
            dossier.mkdir();  // Crée le répertoire si nécessaire
        }

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            File fichier = new File(dossier, entry.getKey());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
                writer.write(entry.getValue());
            } catch (IOException e) {
                System.out.println("Erreur lors de la sauvegarde du fichier : " + entry.getKey());
            }
        }
    }

    // Ajouter un contact
    public void ajouterContact(String nom, String numero) {
        contacts.put(nom, numero);
        sauvegarderContacts();
    }

    // Supprimer un contact
    public void supprimerContact(String nom) {
        contacts.remove(nom);
        sauvegarderContacts();
    }

    // Rechercher un contact par nom
    public String rechercherContact(String nom) {
        return contacts.get(nom);
    }

    // Changer le numéro de téléphone d'un contact
    public void changerNumero(String nom, String nouveauNumero) {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
            sauvegarderContacts();
        } else {
            System.out.println("Le contact n'existe pas.");
        }
    }
}

