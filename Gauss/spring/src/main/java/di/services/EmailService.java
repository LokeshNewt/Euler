package di.services;

/**
 * Created by neerbans on 6/13/2017.
 */
public class EmailService implements MessageService {

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email sent to " + rec + " with Message = " + msg);
        return true;
    }
}
