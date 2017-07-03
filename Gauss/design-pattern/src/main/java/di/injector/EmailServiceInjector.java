package di.injector;

import di.consumer.Consumer;
import di.consumer.MyDIApplication;
import di.service.EmailServiceImpl;
import di.service.MessageService;

/**
 * Created by neerbans on 6/11/2017.
 */
public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }
}
