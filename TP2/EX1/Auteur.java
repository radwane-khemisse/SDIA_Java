package EX1;

public class Auteur extends Personne {
    int numAuteur;
    public Auteur(String nom, String prenom, String email,String tel,int age,int numAuteur)
    {
        super(nom,prenom,email,tel,age);
        this.numAuteur=numAuteur;
    }

    public void Afficher()
    {
        System.out.println("Informations de l'auteur:");
        super.Afficher();
        System.out.println("numero de l'Auteur : "+numAuteur);
    }
}
