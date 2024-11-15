package coll_exo2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        HashMap<String, Double> grades = new HashMap<>();
        grades.put("oussama", 15.0);
        grades.put("redone", 12.5);
        grades.put("aya", 12.0);
        grades.put("achraf", 19.0);
        grades.put("souad", 14.5);
        System.out.println("Les notes :");
        System.out.println(grades);
        String st = "aya";
        grades.put(st, grades.get(st) + 2.0);
        System.out.println("After increasing " + st + "'s grade:" + grades.get(st));
        System.out.println("After modification of the grade: ");
        System.out.println(grades);

        System.out.println("la taille du map est: " + grades.size());
        String st2 = "aya";
        grades.remove(st);
        System.out.println("After removing " + st2 + "'s grade:");
        System.out.println(grades);

        System.out.println("la taille du map est: " + grades.size());
        Double sum = 0.0;
        Double mini= 20.0;
        Double maxi=0.0;
        int check_20=0;
        for (Double grade : grades.values())
        {
            sum+=grade;
            if (grade < mini)
            {
                mini=grade;
            }
            if (grade > maxi)
            {
                maxi=grade;
            }
            if(grade == 20.0)
            {
                check_20=1;
            }
        }
        System.out.println("The average of grades is: " + sum/grades.size());
        System.out.println("The maximum of grades is: " + maxi);
        System.out.println("The minimum of grades is: " + mini);

        if ( check_20==1)
        {
            System.out.println("y'a une note parfaite 20/20");
        }
        else
        {
            System.out.println("y'a pas une note parfaite 20/20");
        }
        grades.forEach((name, grade) -> System.out.print(name + ": " + grade + ", "));








    }
}
