package EXO1;

import java.io.File;

public class SimulerCommandeLS {

    public static void listerFichiersEtRepertoires(String chemin) {
        File repertoire = new File(chemin);

        if (!repertoire.exists() || !repertoire.isDirectory()) {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
            return;
        }

        File[] fichiers = repertoire.listFiles();
        if (fichiers == null) {
            System.out.println("Impossible d'accéder au contenu du répertoire.");
            return;
        }

        for (File fichier : fichiers) {
            afficherInformationsFichier(fichier);
            if (fichier.isDirectory()) {
                listerFichiersEtRepertoires(fichier.getAbsolutePath());
            }
        }
    }

    public static void afficherInformationsFichier(File fichier) {
        String type = fichier.isDirectory() ? "<DIR>" : "<FILE>";
        String droits = (fichier.canRead() ? "r" : "-") +
                (fichier.canWrite() ? "w" : "-") +
                (fichier.isHidden() ? "h" : "-");

        System.out.printf("%s %s %s%n", fichier.getAbsolutePath(), type, droits);
    }

    public static void main(String[] args) {
        System.out.println("Entrez le chemin complet du répertoire à lister :");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String chemin = scanner.nextLine();
        scanner.close();

        listerFichiersEtRepertoires(chemin);
    }
}
