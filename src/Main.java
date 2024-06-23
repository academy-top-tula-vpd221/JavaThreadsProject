import Threads.*;
import Threads.Counter;
import java.util.concurrent.*;


public class Main
{
    public static void main(String[] args)
    {
        Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new SendThread(exchanger)).start();
        new Thread(new TakeThread(exchanger)).start();
    }
}