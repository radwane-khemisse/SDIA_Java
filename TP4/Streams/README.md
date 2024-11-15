# Java Streams Practical Activity
**Author:** Radwane Khemisse  
**Date:** November 2024

## Introduction

This practical activity focuses on  Java Streams by applying various stream operations. Through exercises, we will practice filtering, mapping, reducing, and other stream operations commonly used in Java development to manipulate lists of data effectively.

## Exercises

### exercice 1: Word List Operations
Given a list of words, perform the following operations using Java Streams:

1. **Filter Words Containing "a":**
   ```java
   List<String> containsA = words.stream()
                .filter(word -> word.contains("a"))
                .collect(Collectors.toList());

2. **Reverse Words with Length > 3:**
Filters words longer than 3 characters and reverses each.
    ```java
   List<String> lengthGreaterThan3Reversed = words.stream()
                .filter(word -> word.length() > 3)
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.toList());
   
3. **Flatten Words Containing "e" into Character Lists:**
Filters words containing "e" and flattens them into a list of characters.
    ```java
   List<Character> containsEFlattened = words.stream()
                .filter(word -> word.contains("e"))
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());

4. **Convert Each Word to Uppercase:** 
Transforms each word to uppercase.
    ```java
   List<String> ListToMaj = words.stream()
                .map(word ->word.toUpperCase())
                .collect(Collectors.toList());

5. **Convert Each Word to Its Length:**
Maps each word to its length.
   ```java
    List<Integer> ListToLength = words.stream()
                .map(word-> word.length())
                .collect(Collectors.toList());
   
6. **Flatten All Words into a Character List:**
Converts each word to a list of characters and flattens them.

   ```java
    List<Character> ListAplatti = words.stream()
                .flatMap(word-> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
   
7. **Map Words to "name- Index" Format:**
Transforms each word to include its index in the format "Name - Index".
    ```java
   List<String> wordsWithIndex = IntStream.range(0, words.size())
                .mapToObj(i -> words.get(i) + " - " + i)
                .collect(Collectors.toList());

### Exercice 2 : Employee List Operations
Create a list of employees, each with a name, department, and salary, then perform these operations:

1. **Calculate Total Salary Sum:**
Uses mapToDouble and sum to calculate the total salary.
    ```java
   double SumSalaire = employes.stream()
                .mapToDouble(employe->employe.salaire)
                .sum();

2. **Sort Employees by Name Alphabetically:**
Sorts employees by name.
    ```java
   List<Employe> SortedEmployes = employes.stream()
                .sorted(Comparator.comparing(employe -> employe.nom))
                .collect(Collectors.toList());

3. **Find Employee with Minimum Salary:**
Finds the employee with the lowest salary.
    ```java
    Optional<Employe> MinSalary = employes.stream()
                .min(Comparator.comparingDouble(employe->employe.salaire));

4. **Filter Employees with Salary Above User-Specified Value:**
Filters employees whose salary is above a value provided by the user.
    ```java
   Scanner sc=new Scanner(System.in);
        System.out.print("Inserer une veleur de salaire min: ");
        double sal = sc.nextDouble();
        List<Employe> AboveSalary = employes.stream()
                .filter(employe->employe.salaire > sal)
                .collect(Collectors.toList());

5. **Find Employee with Maximum Salary:**
   Finds the employee with the highest salary using reduce.
    ```java
    Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((e1, e2) -> e1.salaire > e2.salaire ? e1 : e2);
        employeSalaireMax.ifPresent(employe -> System.out.println("Employé avec le salaire le plus élevé : " + employe));


6. **Concatenate All Employee Names:**
   Concatenates the names of all employees into a single string.
    ```java
   String NomConcatenated = employes.stream()
                .map(e -> e.nom)
                .reduce("", (nom1, nom2) -> nom1 + " " + nom2).trim();

# Conclusion
This practical activity demonstrates the versatility and power of Java Streams for functional programming in data manipulation. Through these exercises, we gained proficiency in filtering, transforming, and aggregating data in Java, strengthening our understanding of Streams and functional operations in a real-world context.









