package Exo1;

public class Talkative implements Runnable {
    int att;
    public Talkative(int att) {
        this.att = att;
    }



    @Override
    public void run() {
        for (int i=0; i<100 ; i++)
        {
            System.out.print(att+"\n");
        }


    }
}
