import java.util.Scanner;
public class Occurences {
    public void NbOccurences(String ch)
    {
        String ch_lower = ch.toUpperCase();
        int[] tab = new int[26];
        for (int i : tab)
        {
            i=0;
        }
        for (int i=0; i<ch_lower.length(); i++)
        {
            char c = ch_lower.charAt(i);
            int index = c - 'A';
            tab[index]++;
        }
        for (int i=0; i<tab.length; i++)
        {
            if( tab[i] != 0 )
            {
                char k= (char) (i+'A');
                System.out.println("the letter "+ k + " is repeated "+tab[i]+" times");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Occurences occ = new Occurences();
        System.out.print("Enter the phrase: ");
        String ch = sc.nextLine();
        System.out.println("Here's an overview of the occurences of the caracters : ");
        occ.NbOccurences(ch);


    }
}
