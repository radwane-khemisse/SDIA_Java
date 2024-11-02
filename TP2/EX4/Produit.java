package EX4;

public class Produit {
    int id;
    String nom;
    String marque;
    float prix;
    String description;
    int stock;

    public Produit(int id, int stock, String description, float prix, String marque, String nom) {
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.prix = prix;
        this.marque = marque;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
