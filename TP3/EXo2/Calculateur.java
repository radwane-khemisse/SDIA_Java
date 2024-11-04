package EXo2;

public class Calculateur {
    public Calculateur() {}

    public void testRacineCarree(int nombre) throws RacineCarreeException {
        if (nombre < 0) {
            throw new RacineCarreeException(nombre);
        }
    }

    public static void main(String[] args) {
        Calculateur calc = new Calculateur();
        try {
            calc.testRacineCarree(-5);
            System.out.println("Pas d'exception");
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }

        try {
            calc.testRacineCarree(25);
            System.out.println("Pas d'exception");
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }
    }
}
