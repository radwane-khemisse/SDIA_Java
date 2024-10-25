import java.util.Scanner;

public class Conjugaison {
    public void Present(String verb){
        String terminaison = verb.substring(verb.length()-2);
        if (terminaison.equals("er"))
        {
            String cardinal = verb.substring(0, verb.length()-2);
            System.out.println("je " + cardinal +"e");
            System.out.println("tu " + cardinal +"es");
            System.out.println("il " + cardinal +"e");
            System.out.println("nous " + cardinal +"ons");
            System.out.println("vous " + cardinal +"ez");
            System.out.println("ils " + cardinal +"ent");
        }
    }

    public static void main(String[] args) {
        Conjugaison c = new Conjugaison();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a verb you want to conjugate to present: ");
        String verb = sc.nextLine();

        System.out.println("Here is the conjugation of the verb: " + verb );
        c.Present(verb);


    }
}
