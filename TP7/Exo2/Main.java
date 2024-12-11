package Exo2;

public class Main {
    public static void main(String[] args) {
        int[] tab1 = new int[20];
        for (int i = 0; i < tab1.length; i++) {
            tab1[i] = i + 1;
        }

        Sommeur som1 = new Sommeur(tab1,1,3);
        Sommeur som2 = new Sommeur(tab1,2,7);
        Sommeur som3 = new Sommeur(tab1,0,15);

        Thread t2 = new Thread(som1);
        Thread t1 = new Thread(som2);
        Thread t3 = new Thread(som3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(som1.getSomme());
        System.out.println(som2.getSomme());
        System.out.println(som3.getSomme());


    }



}
