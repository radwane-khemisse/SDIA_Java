package EX3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Déclaration et instanciation d'une liste de trois ordinateurs
        Ordinateur ordinateur1 = new Ordinateur("Laptop A", "MarqueX", 1000.0, "Un ordinateur portable performant", 10);
        Ordinateur ordinateur2 = new Ordinateur("Laptop B", "MarqueY", 800.0, "Ordinateur portable de milieu de gamme", 15);
        Ordinateur ordinateur3 = new Ordinateur("Laptop C", "MarqueZ", 1200.0, "Ordinateur portable haute performance", 5);

        ArrayList<Ordinateur> listeOrdinateurs = new ArrayList<>();
        listeOrdinateurs.add(ordinateur1);
        listeOrdinateurs.add(ordinateur2);
        listeOrdinateurs.add(ordinateur3);

        // Déclaration et instanciation d'une catégorie
        Categorie categorie = new Categorie("Ordinateurs Portables", "Catégorie des ordinateurs portables", listeOrdinateurs);

        // Déclaration et instanciation d'un client
        List<Commande> listeCommandes = new ArrayList<>();
        Client client = new Client("Redone", "Khemisse", "SYOS", "khemisse@gmail.com", "khenifra", "0606060606", listeCommandes);

        // Déclaration et instanciation d'une commande pour le client
        Commande commande = new Commande("En traitement", new Date(), client, "00001");
        client.AjouterCommande(commande);

        // Déclaration et instanciation d'une liste de trois lignes de commandes pour la commande et les ordinateurs créés
        LigneCommande ligneCommande1 = new LigneCommande(2, commande, ordinateur1);
        LigneCommande ligneCommande2 = new LigneCommande(1, commande, ordinateur2);
        LigneCommande ligneCommande3 = new LigneCommande(3, commande, ordinateur3);

        ArrayList<LigneCommande> lignesDeCommande = new ArrayList<>();
        lignesDeCommande.add(ligneCommande1);
        lignesDeCommande.add(ligneCommande2);
        lignesDeCommande.add(ligneCommande3);

        // Affichage de toutes les informations de la commande
        System.out.println("Informations du client : \n" + client);
        System.out.println("\nInformations de la commande : \n" + commande);
        System.out.println("\nDétails de la commande : ");
        for (LigneCommande ligne : lignesDeCommande) {
            System.out.println(ligne);
        }
    }
}
