package Threads;
import java.util.*;
public class Driver implements Runnable{

    CarStore store;

    public Driver(CarStore store){
        this.store = store;
    }
    @java.lang.Override
    public void run() {
        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
            int time = 100 + rnd.nextInt(100);
            try{
                Thread.sleep(time);
            }
            catch(InterruptedException ex){}
            store.get();
//            synchronized (store){
//                int time = 100 + rnd.nextInt(100);
//                try{
//                    Thread.sleep(time);
//                }
//                catch(InterruptedException ex){}
//                store.get();
//            }
        }
    }
}
