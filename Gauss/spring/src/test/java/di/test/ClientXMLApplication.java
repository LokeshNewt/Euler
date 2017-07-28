package di.test;

import di.consumer.MyXMLApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by neerbans on 6/13/2017.
 */
public class ClientXMLApplication {

    public static void main (String [] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);
        app.processMessage("Hi Pankaj", "pankaj@abc.com");
    }
}
