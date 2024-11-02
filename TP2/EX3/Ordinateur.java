package EX3;

public class Ordinateur {
    String nom;
    String marque;
    double prix;
    String description;
    int stock;

    public Ordinateur(String nom, String marque, double prix, String description, int stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    public Ordinateur() {}

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double CalculPrix(int quantity)
    {
        return prix*quantity;
    }

    @Override
    public String toString() {
        return "Ordinateur {" +
                "\n\tNom = '" + nom + '\'' +
                ",\n\tMarque = '" + marque + '\'' +
                ",\n\tPrix = " + prix +
                ",\n\tDescription = '" + description + '\'' +
                ",\n\tStock = " + stock +
                "\n}";
    }
}
