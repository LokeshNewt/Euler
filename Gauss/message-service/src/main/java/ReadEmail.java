import javax.mail.*;
import java.util.Properties;

/**
 * Created by neerbans on 10/10/2017.
 */
public class ReadEmail {

    public static void main(String[] args) {

        try {

            //        String to = "neeraj.bansal589@gmail.com";//change accordingly
            String to = "neeraj.bansal589@gmail.com";
//        String from = "spockk93@gmail.com";//change accordingly
            String from = "neeraj.bansal589@gmail.com";//change accordingly
//        String password = "vulcan93";
            String password = "25042010";
//        String host = "smtp.gmail.com";//or IP address
            String host = "exchangecasarray.corp.edifecs.com";//or IP address

            //Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gamil.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "neeraj.bansal589@gmail.com", "25042010");
            Folder inbox = store.getFolder("Starred");
            inbox.open(Folder.READ_ONLY);
             int messageCount = inbox.getMessageCount();

            System.out.println("Total messages :- " + messageCount);

            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");

            for (int i = 0; i < 10; i++) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
            }

            inbox.close(true);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
