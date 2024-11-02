package EX2;

public class Manager extends Employe{
    private String service;

    public Manager(String nom,String prenom,String email,String telephone,double salaire,String service)
    {
        super(nom,prenom,email,telephone,salaire);
        this.service=service;
    }

    @Override
    public void calculeraSalaire() {
        this.salaire = this.salaire *1.2;
    }

    @Override
    public String toString() {
        return "Manager\n" +
                " prenom=" + prenom  +"\n"+
                " nom=" + nom +   "\n"+
                " email=" + email  + "\n"+
                " telephone=" + telephone +"\n"+
                " salaire=" + salaire + "\n"+
                " service=" + service ;
    }
}
