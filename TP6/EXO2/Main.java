package EXO2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DossierContact dossierContact = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("Menu :");
            System.out.println("1. Rechercher un numéro de téléphone.");
            System.out.println("2. Ajouter un nouveau contact.");
            System.out.println("3. Supprimer un contact.");
            System.out.println("4. Changer le numéro de téléphone d’un contact.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    // Rechercher un numéro de téléphone
                    System.out.print("Entrez le nom du contact à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    String numero = dossierContact.rechercherContact(nomRecherche);
                    if (numero != null) {
                        System.out.println("Le numéro de téléphone de " + nomRecherche + " est : " + numero);
                    } else {
                        System.out.println("Contact non trouvé.");
                    }
                    break;

                case 2:
                    // Ajouter un nouveau contact
                    System.out.print("Entrez le nom du contact : ");
                    String nomAjout = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String numeroAjout = scanner.nextLine();
                    dossierContact.ajouterContact(nomAjout, numeroAjout);
                    System.out.println("Contact ajouté avec succès.");
                    break;

                case 3:
                    // Supprimer un contact
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    dossierContact.supprimerContact(nomSuppression);
                    System.out.println("Contact supprimé avec succès.");
                    break;

                case 4:
                    // Changer le numéro de téléphone d’un contact
                    System.out.print("Entrez le nom du contact à modifier : ");
                    String nomModification = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro de téléphone : ");
                    String nouveauNumero = scanner.nextLine();
                    dossierContact.changerNumero(nomModification, nouveauNumero);
                    System.out.println("Numéro de téléphone modifié avec succès.");
                    break;

                case 5:
                    // Quitter
                    dossierContact.sauvegarderContacts();
                    System.out.println("Au revoir !");
                    quitter = true;
                    break;

                default:
                    System.out.println("Option invalide. Essayez à nouveau.");
            }
        }

        scanner.close();
    }
}

