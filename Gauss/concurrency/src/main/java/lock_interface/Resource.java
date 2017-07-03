package lock_interface;

/**
 * Created by neerbans on 6/15/2017.
 */
public class Resource {

    public void doSomething(){
        //do some operation, DB read, write etc
        System.out.println("in doSomething() method");
    }

    public void doLogging(){
        //logging, no need for thread safety
        System.out.println("in doLogging() method");
    }
}
