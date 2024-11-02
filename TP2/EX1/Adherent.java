package EX1;

public class Adherent extends Personne {
    int numAdherent;

    public Adherent(String nom, String prenom, String email,String tel,int age, int numAdherent)
    {
        super(nom,prenom,email,tel,age);
        this.numAdherent = numAdherent;
    }
    public void afficher()
    {
        System.out.println("information de l'adherent");
        super.Afficher();
        System.out.println("numero d'Adherent "+numAdherent);
    }
}
