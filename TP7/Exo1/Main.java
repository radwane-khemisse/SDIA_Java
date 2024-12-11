package Exo1;

public class Main {
    public static void main(String[] args) {
        Talkative t1= new Talkative(1);
        Talkative t2= new Talkative(2);
        Talkative t3= new Talkative(3);
        Talkative t4= new Talkative(4);
        Talkative t5= new Talkative(5);
        Talkative t6= new Talkative(6);
        Talkative t7= new Talkative(7);
        Talkative t8= new Talkative(8);
        Talkative t9= new Talkative(9);
        Talkative t10= new Talkative(10);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);
        Thread thread5 = new Thread(t5);
        Thread thread6 = new Thread(t6);
        Thread thread7 = new Thread(t7);
        Thread thread8 = new Thread(t8);
        Thread thread9 = new Thread(t9);
        Thread thread10 = new Thread(t10);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
