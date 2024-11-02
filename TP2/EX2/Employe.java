package EX2;

public abstract class Employe {
    String nom;
    String prenom;
    String email;
    String telephone;
    double salaire; //

    public Employe(String nom, String prenom, String email, String telephone, double salaire)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.salaire = salaire;
    }
    public Employe() {}


    public abstract void calculeraSalaire();

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
