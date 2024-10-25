
import java.util.Scanner;
public class NotesManagement {
    public void DisplayListedNotes(float[] tab)
    {
        float p;
        for (int i = 0; i < tab.length; i++)
        {
            float mini=tab[i];
            int indexmini=i;
            for (int j = i ; j < tab.length; j++)
            {
                if ( tab[j] < mini )
                {
                    mini=tab[j];
                    indexmini=j;
                }
            }
            p=tab[i];
            tab[i]=tab[indexmini];
            tab[indexmini]=p;
            System.out.println(tab[i]);

        }
    }
    public float GetAverage(float[] tab)
    {
        float sum=0;
        for (float i : tab)
        {
            sum += i;
        }
        return sum/tab.length;
    }
    public float GetMax(float[] tab)
    {
        float maxi=tab[0];
        for (float i : tab)
        {
            if (maxi < i)
            {
                maxi=i;
            }
        }
        return maxi;
    }
    public float GetMin(float[] tab)
    {
        float mini=tab[0];
        for (float i : tab)
        {
            if (i < mini)
            {
                mini=i;
            }
        }
        return mini;
    }
    public int NoteCardinal(float[] tab,float note)
    {
        int number=0;
        for (float i : tab)
        {
            if (note == i)
            {
                number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NotesManagement nm = new NotesManagement();

        System.out.print("Enter the number of notes you wish to add: ");
        int n = sc.nextInt();
        float[] tab = new float[n];
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter the mark number "+(i+1)+": ");
            tab[i] = sc.nextFloat();
        }
        System.out.println("Listed marks:  ");
        nm.DisplayListedNotes(tab);

        System.out.println("The average of the marks is: "+nm.GetAverage(tab));

        System.out.println("The maximum of the marks is: "+nm.GetMax(tab));

        System.out.println("The minimum of the marks is: "+nm.GetMin(tab));

        System.out.print("Enter the marks You want to check its cardinal: ");
        float chosen_number = sc.nextFloat();
        System.out.println("the Cardinal of the mark: "+ chosen_number + " is: "+nm.NoteCardinal(tab,chosen_number));
    }
}
