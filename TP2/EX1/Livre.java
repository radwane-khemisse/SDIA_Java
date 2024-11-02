package EX1;

public class Livre {
    int ISBN;
    Auteur auteur;

    public Livre(int ISBN, Auteur auteur)
    {
        this.ISBN = ISBN;
        this.auteur = auteur;
    }

    public void afficher()
    {
        System.out.println("ISBN: " + ISBN);
        auteur.Afficher();
    }

}
