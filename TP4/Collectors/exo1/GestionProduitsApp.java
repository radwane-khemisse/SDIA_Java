package coll_exo1;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args)
    {
        ArrayList<Produit> produits = new ArrayList();
        Produit p1= new Produit(1,"ordinateur",2500);
        Produit p2= new Produit(2,"portable",1500);
        Produit p3= new Produit(3,"montre",3500);
        produits.add(p1);
        produits.add(p2);
        produits.add(p3);
        System.out.println("The list of products");
        produits.forEach(System.out::println);
        produits.remove(1);
        System.out.println("After deleting the portable");
        produits.forEach(System.out::println);
        Produit prod = produits.get(1);
        prod.setNom("manette");
        prod.setPrix(450);
        System.out.println("After updating the montre to manette");
        produits.forEach(System.out::println);
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert the name of the product: ");
        String name = sc.nextLine();
        int a=0;
        for (Produit p : produits)
        {
            if (p.getNom().equals(name))
            {
                System.out.println("product found");
                System.out.println(p);
                a=1;
                break;
            }

        }
        if (a==0)
        {
            System.out.println("product not found");
        }

    }
}
