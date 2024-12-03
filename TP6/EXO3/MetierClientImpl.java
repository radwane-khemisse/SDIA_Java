package EXO3;

import java.io.*;
import java.util.*;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients;
    private String fichier = "clients.dat";

    public MetierClientImpl() {
        clients = getAll();
    }

    @Override
    public Client add(Client client) {
        clients.add(client);
        saveAll();
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clientsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            clientsList = (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucun client trouvé. Un fichier vide sera créé.");
        }
        return clientsList;
    }

    @Override
    public Client findByNom(String nom) {
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(client -> client.getNom().equalsIgnoreCase(nom));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des clients.");
        }
    }
}

