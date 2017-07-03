package producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by neerbans on 6/6/2017.
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i=0; i<=10; i++) {
            try {
                System.out.println("Consumed : " + sharedQueue.take());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
