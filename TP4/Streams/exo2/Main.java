package st_exo2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe("redone", "Finance", 45000));
        employes.add(new Employe("amal", "Marketing", 55000));
        employes.add(new Employe("loubna", "IT", 30000));
        employes.add(new Employe("achraf", "HR", 40000));
        employes.add(new Employe("bilal", "IT", 35000));
        employes.add(new Employe("karima", "Finance", 60000));

        // 1. calcluer la somme total des employes
        double SumSalaire = employes.stream()
                .mapToDouble(employe->employe.salaire)
                .sum();
        System.out.println("la somme totale des salaire est: "+ SumSalaire);

        // 2. trier les employes par ordre alphabetique

        List<Employe> SortedEmployes = employes.stream()
                .sorted(Comparator.comparing(employe -> employe.nom))
                .collect(Collectors.toList());
        System.out.println(SortedEmployes);

        // 3. Trouver l'employe avec le salaire minimum

        Optional<Employe> MinSalary = employes.stream()
                .min(Comparator.comparingDouble(employe->employe.salaire));
        System.out.println(MinSalary);

        // 4.les employes ayant un salaire superierur a sal donner par l'utilisateur
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserer une veleur de salaire min: ");
        double sal = sc.nextDouble();
        List<Employe> AboveSalary = employes.stream()
                .filter(employe->employe.salaire > sal)
                .collect(Collectors.toList());
        System.out.println("les employes avec un salaire plus de: "+sal+" sont : "+AboveSalary);

        // 5. Trouver l'employé avec le salaire le plus élevé
        Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((e1, e2) -> e1.salaire > e2.salaire ? e1 : e2);
        employeSalaireMax.ifPresent(employe -> System.out.println("Employé avec le salaire le plus élevé : " + employe));

        // 6. Concatener les noms de tous les employes
        String NomConcatenated = employes.stream()
                .map(e -> e.nom)
                .reduce("", (nom1, nom2) -> nom1 + " " + nom2).trim();
        System.out.println(NomConcatenated);




    }
}
