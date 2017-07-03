package di.consumer;

import di.services.MessageService;

/**
 * Created by neerbans on 6/13/2017.
 */
public class MyXMLApplication {

    private MessageService service;

    public void setService(MessageService svc) {
        this.service = svc;
    }

    public boolean processMessage(String msg, String rec) {
        return this.service.sendMessage(msg, rec);
    }
}
