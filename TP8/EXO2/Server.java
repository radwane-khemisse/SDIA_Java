package EXO2;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port d'écoute du serveur

        System.out.println("Serveur de fichiers démarré...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("En attente d'une connexion client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion acceptée d'un client : " + clientSocket.getInetAddress());

                // Démarrer un nouveau thread pour gérer le client
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("Bienvenue sur le serveur de fichiers ! Entrez le nom du fichier que vous souhaitez recevoir.");

            String fileName = in.readLine();
            if (fileName != null) {
                System.out.println("Client demande le fichier : " + fileName);
                File file = new File(fileName);

                if (file.exists() && file.isFile()) {
                    out.println("Fichier trouvé. Envoi du contenu...");

                    // Envoyer le contenu du fichier au client
                    try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(file))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fileReader.read(buffer)) != -1) {
                            clientSocket.getOutputStream().write(buffer, 0, bytesRead);
                        }
                        clientSocket.getOutputStream().flush();
                    }
                    System.out.println("Envoi terminé pour le fichier : " + fileName);
                } else {
                    out.println("Erreur : Le fichier demandé n'existe pas.");
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur dans le traitement du client : " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Erreur lors de la fermeture de la connexion client : " + e.getMessage());
            }
        }
    }
}
