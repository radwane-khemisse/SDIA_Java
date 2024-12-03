package EXO3;

import java.util.Scanner;

public class ApplicationProduit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metierProduit = new MetierProduitImpl();
        boolean quitter = false;

        while (!quitter) {
            System.out.println("Menu des produits :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par nom");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    metierProduit.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Nom du produit à rechercher : ");
                    String nomProduit = scanner.nextLine();
                    Produit produit = metierProduit.findByNom(nomProduit);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Stock : ");
                    int stock = scanner.nextInt();
                    Produit nouveauProduit = new Produit(nom, marque, prix, description, stock);
                    metierProduit.add(nouveauProduit);
                    break;
                case 4:
                    System.out.print("Nom du produit à supprimer : ");
                    String nomASupprimer = scanner.nextLine();
                    metierProduit.delete(nomASupprimer);
                    break;
                case 5:
                    metierProduit.saveAll();
                    System.out.println("Produits sauvegardés.");
                    break;
                case 6:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
        scanner.close();
    }
}

