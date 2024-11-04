package EXo1;

public class Vehicule {
    public Vehicule() {}

    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
    }
    public static void main(String[] args) {
        Vehicule v = new Vehicule();
        try {
            v.testVitesse(80);
            System.out.println("Pas d'exception");
        } catch (TropViteException e) {
            e.printStackTrace();
        }

        try {
            v.testVitesse(100);
        } catch (TropViteException e) {
            e.printStackTrace();
        }
    }

}
