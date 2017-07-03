package di.configuration;

import di.services.EmailService;
import di.services.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by neerbans on 6/13/2017.
 */

@Configuration
@ComponentScan(value = {"di.consumer"})
public class DIConfiguration {

    @Bean
    public MessageService getMessageService() {
        return new EmailService();
    }
}
