package EXo3;

import EXo2.RacineCarreeException;

public class Evaluateur
{
    public Evaluateur() {}

    public void verifierNote(int nombre) throws NoteInvalideException {
        if (nombre < 0 || nombre > 20) {
            throw new NoteInvalideException(nombre);
        }
    }
    public static void main(String[] args) {
        Evaluateur ev = new Evaluateur();
        try {
            ev.verifierNote(15);
            System.out.println("Pas d'exception");
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }

        try {
            ev.verifierNote(25);
            System.out.println("Pas d'exception");
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }
    }
}
