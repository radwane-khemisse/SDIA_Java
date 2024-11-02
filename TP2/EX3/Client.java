package EX3;

import java.util.List;

public class Client {
    String nom;
    String prenom;
    String adresse;
    String email;
    String ville;
    String telephone;
    List<Commande> commandes;

    public Client() {}

    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone, List<Commande> commandes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandes = commandes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void AjouterCommande(Commande c)
    {
        int exist=0;
        for (Commande c1 : commandes)
        {
            if (c1.equals(c))
            {
                exist++;
                break;
            }
        }
        if (exist==0) {
            commandes.add(c);
        }
    }
    public void SupprmerCommande(Commande c)
    {
        commandes.remove(c);
    }

    @Override
    public String toString() {
        return "Client {" +
                "\n\tNom = '" + nom + '\'' +
                ",\n\tPrénom = '" + prenom + '\'' +
                ",\n\tAdresse = '" + adresse + '\'' +
                ",\n\tEmail = '" + email + '\'' +
                ",\n\tVille = '" + ville + '\'' +
                ",\n\tTéléphone = '" + telephone + '\'' +
                ",\n\tCommandes = " + commandes +
                "\n}";
    }
}
