package EX1;

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private int age;
    public Personne(String nom, String prenom, String email, String tel, int age)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }


    public void Afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Tel: " + tel);
        System.out.println("Age: " + age);

    }

}
