package coll_exo3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> groupA = new HashSet<>();
        Set<String> groupB = new HashSet<>();

        groupA.add("redone");
        groupA.add("aya");
        groupA.add("loubna");
        groupB.add("abdo");
        groupB.add("karim");
        groupB.add("redone");

        System.out.println("Group A students: " + groupA);
        System.out.println("Group B students: " + groupB);

        Set<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);
        System.out.println("Intersection (students in both groups): " + intersection);

        Set<String> union = new HashSet<>(groupA);
        union.addAll(groupB);
        System.out.println("Union (students in either group): " + union);

    }
}
