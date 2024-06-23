package Threads;
import java.util.concurrent.*;
public class CarStore {
    int cars = 0;
    final int maxCars = 3;

    Semaphore sem;
    public void get(){
        while(cars < 1){
            try{
                wait();
            }
            catch (InterruptedException ex){}
        }

        cars--;

        System.out.println("Car from store");
        System.out.printf("Cars = %d\n", cars);
        notify();
    }

    public void put(){
        while(cars >= maxCars){
            try{
                wait();
            }
            catch (InterruptedException ex){}
        }

        cars++;

        System.out.println("Car into store");
        System.out.printf("Cars = %d\n", cars);
        notify();
    }
}
