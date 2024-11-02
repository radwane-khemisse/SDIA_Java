package EX4;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par id");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    List<Produit> produits = metier.getAll();
                    for (Produit p : produits) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Entrez le mot clé : ");
                    String motCle = scanner.nextLine();
                    List<Produit> produitsTrouves = metier.findByNom(motCle);
                    System.out.println("Produits trouvés :");
                    for (Produit p : produitsTrouves) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'id du produit : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit : ");
                    float prix = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Entrez la description du produit : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    Produit produit = new Produit(id, stock, description, prix, marque, nom);
                    metier.add(produit);
                    System.out.println("Produit ajouté !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit : ");
                    int idRecherche = scanner.nextInt();
                    scanner.nextLine();
                    Produit produitTrouve = metier.findById(idRecherche);
                    if (produitTrouve != null) {
                        System.out.println(produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    int idSuppression = scanner.nextInt();
                    scanner.nextLine();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé !");
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}


