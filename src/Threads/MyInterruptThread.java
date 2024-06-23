package Threads;

public class MyInterruptThread implements Runnable
{
    private boolean isActive;

    public void Disable(){
        isActive = false;
    }

    public MyInterruptThread(){
        isActive = true;
    }

    public void run(){
        System.out.println("Loop is start\n");

        //try{
        int count = 1;
        while(true){
            System.out.printf("%s - %d\n", MyThread.currentThread().getName(), count++);
            //MyThread.sleep(200);
            //if(!isActive)
            if(MyThread.currentThread().isInterrupted())
            {
                System.out.printf("\tt1 interruped %b\n", MyThread.currentThread().isInterrupted());
                break;
            }
            //break;
        }

//        }catch(InterruptedException ex){
//            System.out.printf("\terror %b\n", MyThread.currentThread().isInterrupted());
//        }

        System.out.println("Loop is finish");
    }
}
