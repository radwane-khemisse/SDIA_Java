package EXO2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Adresse du serveur
        int port = 12345; // Port du serveur

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur de fichiers.");

            // Lire le message de bienvenue du serveur
            System.out.println("Serveur : " + in.readLine());

            // Envoyer le nom du fichier au serveur
            System.out.print("Entrez le nom du fichier à recevoir : ");
            String fileName = scanner.nextLine();
            out.println(fileName);

            // Recevoir et sauvegarder le contenu du fichier
            String response = in.readLine();
            if (response.startsWith("Fichier trouvé")) {
                System.out.println("Serveur : " + response);

                // Sauvegarde du fichier reçu
                try (FileOutputStream fileOut = new FileOutputStream("recu_" + fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    InputStream inputStream = socket.getInputStream();
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        fileOut.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Fichier reçu et sauvegardé sous : recu_" + fileName);
            } else {
                System.out.println("Serveur : " + response);
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
