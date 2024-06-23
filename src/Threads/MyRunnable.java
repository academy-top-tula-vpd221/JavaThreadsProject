package Threads;

public class MyRunnable implements Runnable
{
    public void run()
    {
        String name = MyThread.currentThread().getName();
        System.out.printf("Thread %s start!\n", name);
        try
        {
            for(int i = 0; i < 10; i++)
            {
                System.out.printf("\t%s %d\n", name, i);
                MyThread.sleep(200);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println("error");
        }
        System.out.printf("Thread %s finish!\n", name);
    }
}
