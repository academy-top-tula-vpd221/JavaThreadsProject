package Threads;
import java.util.*;
public class CarFactory implements Runnable{
    CarStore store;
    public CarFactory(CarStore store){
        this.store = store;
    }


    @java.lang.Override
    public void run() {

        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
//            synchronized (store){
//                int time = 100 + rnd.nextInt(100);
//                try{
//                    Thread.sleep(time);
//                }
//                catch(InterruptedException ex){}
//                store.put();
//            }
            int time = 100 + rnd.nextInt(100);
            try{
                Thread.sleep(time);
            }
            catch(InterruptedException ex){}
            store.put();
        }
    }
}
