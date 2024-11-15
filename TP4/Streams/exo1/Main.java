package st_exo1;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("redone","amal","karim","said","loubna","souad","ab","greenland");
        System.out.println("list of the words: "+ words);
        // 1. Filtrer les mots qui contiennent la lettre "a"
        List<String> containsA = words.stream()
                .filter(word -> word.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'a': " + containsA);

        // 2. Filtrer les mots de longueur > 3 et inverser chaque mot
        List<String> lengthGreaterThan3Reversed = words.stream()
                .filter(word -> word.length() > 3)
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots de longueur > 3, inversés : " + lengthGreaterThan3Reversed);

        // 3. Filtrer les mots contenant "e" et les aplatir en une liste de caractères
        List<Character> containsEFlattened = words.stream()
                .filter(word -> word.contains("e"))
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'e' aplatis en caractères : " + containsEFlattened);

        // 4. Transformer chaque mot en majuscules
        List<String> ListToMaj = words.stream()
                .map(word ->word.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("List en maj:  " + ListToMaj);

        // 5. Convertir chaque mot en sa longueur
        List<Integer> ListToLength = words.stream()
                .map(word-> word.length())
                .collect(Collectors.toList());
        System.out.println("longuer de chaque chaine  " + ListToLength);

        // 6. Transformer chaque mot en une liste de caractères, puis aplatir en une seule liste de caractères
        List<Character> ListAplatti = words.stream()
                .flatMap(word-> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Liste aplatie de tous les caractères : " + ListAplatti);


        // 7. Transformer chaque mot en la forme "Nom - Index"
        List<String> wordsWithIndex = IntStream.range(0, words.size())
                .mapToObj(i -> words.get(i) + " - " + i)
                .collect(Collectors.toList());
        System.out.println("Mots avec index : " + wordsWithIndex);







    }
}
