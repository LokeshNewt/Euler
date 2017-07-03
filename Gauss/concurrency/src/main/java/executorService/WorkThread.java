package executorService;

/**
 * Created by neerbans on 6/2/2017.
 */
public class WorkThread implements Runnable {

    private String command;

    private static final ThreadLocal<Long> l = ThreadLocal.withInitial(() -> 2L);

    public WorkThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command );
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
            System.out.println("in process command ------------------------------------------------------- variable value " + new Sequence().getNext());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.command;
    }
}
