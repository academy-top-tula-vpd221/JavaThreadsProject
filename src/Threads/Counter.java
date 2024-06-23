package Threads;

public class Counter implements Runnable{

    MyResourse resourse;

    public Counter(MyResourse resourse){
        this.resourse = resourse;
    }

    @java.lang.Override
    public synchronized void run() {

        //resourse.amount = 1;
        for(int i = 0; i < 10000; i++)
        {

            //resourse.amount++;

            //System.out.printf("%s %d\n", MyThread.currentThread().getName(), resourse.amount);
            synchronized (resourse) {
                resourse.amount++;
            }

//            try{
//                MyThread.sleep(200);
//            }
//            catch (InterruptedException ex){}
        }

    }
}

