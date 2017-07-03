package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by neerbans on 6/2/2017.
 */
public class ExeSer {

    public static void main (String args []) {

        ExeSer exeSer = new ExeSer();

        exeSer.joinExample();

    }

    //ExecutorService
    private void executorServiceExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i=0; i < 10; i++) {
            Runnable worker = new WorkThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated());

        System.out.println("Finished all threads");
    }

    //Thread.join()
    private void joinExample() {
        Thread t1 = new Thread(new WorkThread("1"), "t1");
        Thread t2 = new Thread(new WorkThread("2"), "t2");
        Thread t3 = new Thread(new WorkThread("3"), "t3");
        Thread t4 = new Thread(new WorkThread("4"), "t4");
        Thread t5 = new Thread(new WorkThread("5"), "t5");
        Thread t6 = new Thread(new WorkThread("6"), "t6");
        Thread t7 = new Thread(new WorkThread("7"), "t7");
        Thread t8 = new Thread(new WorkThread("8"), "t8");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
