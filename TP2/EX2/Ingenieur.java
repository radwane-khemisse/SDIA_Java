package EX2;

public class Ingenieur extends Employe  {
    private String specialite;

    public Ingenieur(String nom, String prenom, String email, String telephone,double salaire, String specialite)
    {
        super(nom,prenom,email,telephone,salaire);
        this.specialite = specialite;

    }


    @Override
    public void calculeraSalaire() {
        this.salaire = this.salaire * 1.15;

    }

    @Override
    public String toString() {
        return "Ingenieur\n" +
                " prenom=" + prenom  +"\n"+
                " nom=" + nom +   "\n"+
                " email=" + email  + "\n"+
                " telephone=" + telephone +"\n"+
                " salaire=" + salaire + "\n"+
                " specialite=" + specialite ;
    }
}
