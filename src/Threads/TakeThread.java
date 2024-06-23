package Threads;
import java.util.concurrent.*;

public class TakeThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public TakeThread(Exchanger<String> exchanger){
        this.exchanger = exchanger;
        message = "Hello from Take Thread!";
    }

    @java.lang.Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("Take Thread has reciver: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
