package EX1;

public class Main {
    public static void main(String[] args) {

        Adherent adherent = new Adherent("redone","khemisse","khemisse@gmail.com","0606060606",21,4315);
        Auteur auteur = new Auteur("redone","khemisse","khemisse@gmail.com","0606060606",21,2);
        Livre livre= new Livre(34,auteur);
        livre.afficher();
        adherent.afficher();



    }
}
