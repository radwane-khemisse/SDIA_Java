package EX4;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
public class MetierProduitImpl implements IMetierProduit{
    List<Produit> produits = new ArrayList<>();
    @Override
    public void add(Produit p) {
        produits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        List<Produit> liste=new ArrayList<Produit>();
        for (Produit p : produits)
        {
            if (p.nom.contains(motCle))
            {
                liste.add(p);
            }
        }
        return liste;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits)
        {
            if (p.id == id)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        for (Produit p : produits)
        {
            if (p.id == id)
            {
                produits.remove(p);
                break;
            }
        }

    }
}
