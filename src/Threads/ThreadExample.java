package Threads;
import java.util.concurrent.*;

public class ThreadExample
{
    public static void ThreadRun()
    {
        new MyThread("mythread 1").start();
        new MyThread("mythread 2").start();
        for(int i = 0; i < 5; i++)
        {
            System.out.printf("Main thread %d\n", i);
            try{
                Thread.sleep(200);
            }
            catch(InterruptedException ex)
            {
                System.out.println("error");
            }
        }
        System.out.println("Main for finish");
    }

    public static void ThreadAndRunnable()
    {
        //        try
//        {
//            MyThread t1 = new MyThread("mythread 1");
//            MyThread t2 = new MyThread("mythread 2");
//            t1.start();
//            t2.start();
//            for(int i = 0; i < 5; i++)
//            {
//                System.out.printf("Main thread %d\n", i);
//                Thread.sleep(200);
//            }
//            t1.join();
//            t2.join();
//            System.out.println("Main for finish");
//        }
//        catch(InterruptedException ex)
//        {
//            System.out.println("error");
//        }


        //ThreadExample.ThreadRun();
        try
        {
            Thread t1 = new Thread(new MyRunnable());
            Thread t2 = new Thread(()->{
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
            });
            t1.start();
            t2.start();
            for(int i = 0; i < 5; i++)
            {
                System.out.printf("Main thread %d\n", i);
                Thread.sleep(200);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println("error");
        }
    }

    public static void InrerruptTread()
    {
        System.out.println("Main is start");
        MyInterruptThread mt1 = new MyInterruptThread();
        Thread t1 = new Thread(mt1);
        try{
            t1.start();
            MyThread.sleep(2000);
            //mt1.Disable();
            t1.interrupt();
        }
        catch(InterruptedException ex){
            System.out.printf("error %b\n", t1.isInterrupted());
        }
        System.out.printf("t1 interruped %b\n", t1.isInterrupted());
        System.out.println("Main is finish");
    }

    public static void SynchronizedResource()
    {
        MyResourse resourse = new MyResourse();
        Thread[] trs = new Thread[5];
        for(int i = 0; i < 5; i++)
        {
            Thread t = new Thread(new Counter(resourse), "thread" + i);
            t.start();
            trs[i] = t;
        }

        try{
            //Thread.sleep(5000);
            for(Thread t : trs)
                t.join();
        }
        catch(InterruptedException ex){}



        System.out.printf("%d", resourse.amount);
    }

    public static void WaitNotifySemaphore()
    {
        // wait notify
//        CarStore store = new CarStore();
//        CarFactory factory = new CarFactory(store);
//        Driver driver = new Driver(store);
//        new Thread(factory).start();
//        new Thread(driver).start();

        // semaphore

        Semaphore sem = new Semaphore(3);
        for(int i = 0; i < 10; i++)
            new Car(sem, i + 1).start();
    }
}