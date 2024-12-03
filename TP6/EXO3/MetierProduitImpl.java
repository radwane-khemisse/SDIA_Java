package EXO3;

import java.io.*;
import java.util.*;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits;
    private String fichier = "produits.dat";

    public MetierProduitImpl() {
        produits = getAll();
    }

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        saveAll();
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produitsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            produitsList = (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucun produit trouvé. Un fichier vide sera créé.");
        }
        return produitsList;
    }

    @Override
    public Produit findByNom(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(produit -> produit.getNom().equalsIgnoreCase(nom));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des produits.");
        }
    }
}
