package di.service;

/**
 * Created by neerbans on 6/11/2017.
 */
public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Email sent to " + rec + " with Message = " + msg);
    }

}
