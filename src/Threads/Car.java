package Threads;
import java.util.concurrent.*;
import java.util.*;
public class Car extends Thread {
    Semaphore sem;
    int number;
    int countMax = 3;
    int countCurr = 0;
    public Car(Semaphore sem, int number){
        this.sem = sem;
        this.number = number;
    }

    public void run(){
        Random rnd = new Random();
        try{
            while(countCurr <= countMax){
                sem.acquire();
                System.out.printf("Car %d into store\n", number);
                int time = 100 + rnd.nextInt(100);
                Thread.sleep(time);
                System.out.printf("Car %d from store\n", number);
                sem.release();

                time = 200 + rnd.nextInt(200);
                Thread.sleep(time);
                countCurr++;
            }
        }
        catch(InterruptedException ex){}
    }
}
