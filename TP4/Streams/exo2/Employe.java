package st_exo2;

class Employe {
    String nom;
    String departement;
    double salaire;

    public Employe(String nom, String departement, double salaire) {
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe{nom='" + nom + "', departement='" + departement + "', salaire=" + salaire + '}';
    }
}
