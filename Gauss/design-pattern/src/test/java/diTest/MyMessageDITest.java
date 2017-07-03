package diTest;

import di.consumer.Consumer;
import di.injector.EmailServiceInjector;
import di.injector.MessageServiceInjector;
import di.injector.SMSServiceInjector;

/**
 * Created by neerbans on 6/11/2017.
 */
public class MyMessageDITest {

    public static void main(String [] args) {

        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "40888888888";

        MessageServiceInjector injector = null;
        Consumer app = null;

        // send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        // send sms
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
}
