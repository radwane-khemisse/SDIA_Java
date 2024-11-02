package EX2;

public class Main {
    public static void main(String[] args) {

        Ingenieur ingenieur = new Ingenieur("redone","khemisse","redone@gmail.com","0606060606",15000,"mecanique");

        System.out.println(ingenieur);
        ingenieur.calculeraSalaire();
        System.out.println(ingenieur);

        Manager manager = new Manager("karim","karim","karim@gmail.com","12211221",10000,"IT");
        System.out.println(manager);
        manager.calculeraSalaire();
        System.out.println(manager);
    }
}