package di.consumer;

/**
 * Created by neerbans on 6/11/2017.
 */
public interface Consumer {

    void processMessages(String msg, String rec);
}
