import java.util.Scanner;
public class Menu {
    private String str = "";
    private Scanner scanner = new Scanner(System.in);
    public void Saisir() {
        System.out.print("Enter the phrase : ");
        str = scanner.nextLine();
    }
    public void Afficher()
    {
        System.out.println("the phrase entered is : "+str);
    }
    public void Inverser()
    {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str2 += str.charAt(i);
        }
        System.out.println("reversed phrase is: " + str2);
    }
    public void NombreMots()
    {
        String[] phrase = str.trim().split("\\s+");
        System.out.println("Number of words: " + phrase.length);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Enter a phrase");
            System.out.println("2. Display the phrase");
            System.out.println("3. Inverse the phrase");
            System.out.println("4. Count the number of words");
            System.out.println("5. Quit");
            System.out.print("Choose between (1-5): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    menu.Saisir();
                    break;
                case 2:
                    menu.Afficher();
                    break;
                case 3:
                    menu.Inverser();
                    break;
                case 4:
                    menu.NombreMots();
                    break;
                case 5:
                    System.out.println("Good bye !");
                    break;
                default:
                    System.out.println("Invalid choice: choose between (1-5)!");
            }

            if (choice != 5) {
                System.out.println("\nTouch the keyboard to go back to the main menu!");
                scanner.nextLine();
            }

        } while (choice != 5);

    }
}
