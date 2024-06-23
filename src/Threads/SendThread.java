package Threads;
import java.util.concurrent.*;
import java.lang.*;
public class SendThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public SendThread(Exchanger<String> exchanger){
        this.exchanger = exchanger;
        message = "Hello from Semd Thread!";
    }

    @java.lang.Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("Send Thread has reciver: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
