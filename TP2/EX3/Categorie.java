package EX3;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class Categorie {
    String nom;
    String description;
    ArrayList<Ordinateur> ordinateurs;

    public Categorie() {}

    public Categorie(String nom, String description, ArrayList<Ordinateur> ordinateurs) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = ordinateurs;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrdinateurs(ArrayList<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }

    public void AjouterOrdinateur(Ordinateur ordinateur)
    {
        int exist =0;
        for (Ordinateur ord : ordinateurs)
        {
            if (ord.equals(ordinateur))
            {
                exist++;
                break;
            }
        }
        if (exist == 0)
        {
            ordinateurs.add(ordinateur);
        }
    }
    public void SupprimerOrdinateur(Ordinateur ordinateur)
    {
        ordinateurs.remove(ordinateur);
    }
    public ArrayList<Ordinateur> RechercherParPrix(double prix)
    {
        ArrayList<Ordinateur> ordiMatchedPrice = new ArrayList();
        for (Ordinateur ord : ordinateurs)
        {
            if (ord.prix == prix)
            {
                ordiMatchedPrice.add(ord);
            }
        }

        return ordiMatchedPrice;
    }

    @Override
    public String toString() {
        return "Categorie {" +
                "\n\tNom = '" + nom + '\'' +
                ",\n\tDescription = '" + description + '\'' +
                ",\n\tOrdinateurs = " + ordinateurs +
                "\n}";
    }
}
