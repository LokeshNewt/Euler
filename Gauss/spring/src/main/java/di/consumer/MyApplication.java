package di.consumer;

import di.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by neerbans on 6/13/2017.
 */
// the point is this class is independent of email or text message
@Component
public class MyApplication {

    private MessageService service;

    @Autowired
    public void serService(MessageService svc) {
        this.service = svc;
    }

    public boolean processMessage(String msg, String rec) {
        return this.service.sendMessage(msg, rec);
    }
}
