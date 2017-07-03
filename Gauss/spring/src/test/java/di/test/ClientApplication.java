package di.test;

import di.configuration.DIConfiguration;
import di.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by neerbans on 6/13/2017.
 */
public class ClientApplication {

    public static void main(String [] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        context.close();
    }
}
