package executorService;

/**
 * Created by neerbans on 6/2/2017.
 */
public class Sequence {

    private static int value = 0;

    public int getNext() {
        return value++;
    }
}
