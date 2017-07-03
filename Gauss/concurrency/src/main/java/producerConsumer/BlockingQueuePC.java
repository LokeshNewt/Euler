package producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by neerbans on 6/6/2017.
 */
public class BlockingQueuePC {

    public static void main (String args []) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingDeque<>();

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);

        Thread producerThread = new Thread(producer, "Producer Thread");
        Thread consumerThread = new Thread(consumer, "Consumer Thread");

//        producerThread.sleep()

        producerThread.start();
        consumerThread.start();
    }
}
