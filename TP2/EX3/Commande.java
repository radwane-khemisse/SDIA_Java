package EX3;

import java.util.Date;

public class Commande {
    String reference;
    Client client;
    Date date;
    String EtatCommande;

    public Commande() {}

    public Commande(String etatCommande, Date date, Client client, String reference) {
        EtatCommande = etatCommande;
        this.date = date;
        this.client = client;
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtatCommande() {
        return EtatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        EtatCommande = etatCommande;
    }

    @Override
    public String toString() {
        return "Commande {" +
                "\n\tRéférence = '" + reference + '\'' +
                ",\n\tClient = " + client.getNom() + " " + client.getPrenom() +
                ",\n\tDate = " + date +
                ",\n\tÉtat de la commande = '" + EtatCommande + '\'' +
                "\n}";
    }
}
