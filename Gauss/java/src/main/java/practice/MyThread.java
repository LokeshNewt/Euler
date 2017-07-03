package practice;

/**
 * Created by neerbans on 6/19/2017.
 */
public class MyThread {
    public static void main(String args[]) {
        new newthread();
    }
}

class newthread extends Thread {
    Thread t;
    newthread() {
        t = new Thread(this,"My Thread");
        t.start();
    }
    public void run() {
        try {
            t.join();
            System.out.println(t.getName());
        }
        catch(Exception e) {
            System.out.print("Exception");
        }
    }
}