package EXO3;

import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierClientImpl metierClient = new MetierClientImpl();
        boolean quitter = false;

        while (!quitter) {
            System.out.println("Menu des clients :");
            System.out.println("1. Afficher la liste des clients");
            System.out.println("2. Rechercher un client par nom");
            System.out.println("3. Ajouter un nouveau client");
            System.out.println("4. Supprimer un client");
            System.out.println("5. Sauvegarder les clients");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    // Afficher tous les clients
                    metierClient.getAll().forEach(System.out::println);
                    break;
                case 2:
                    // Rechercher un client par son nom
                    System.out.print("Nom du client à rechercher : ");
                    String nomClient = scanner.nextLine();
                    Client client = metierClient.findByNom(nomClient);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client non trouvé.");
                    }
                    break;
                case 3:
                    // Ajouter un nouveau client
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    Client nouveauClient = new Client(nom, prenom, adresse, tel, email);
                    metierClient.add(nouveauClient);
                    break;
                case 4:
                    // Supprimer un client
                    System.out.print("Nom du client à supprimer : ");
                    String nomASupprimer = scanner.nextLine();
                    metierClient.delete(nomASupprimer);
                    break;
                case 5:
                    // Sauvegarder tous les clients
                    metierClient.saveAll();
                    System.out.println("Clients sauvegardés.");
                    break;
                case 6:
                    // Quitter l'application
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
        scanner.close();
    }
}

