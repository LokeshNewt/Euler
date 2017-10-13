import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by neerbans on 10/10/2017.
 */
public class SendEmail {

    public static void main(String [] args){
        SendEmail se = new SendEmail();
        se.send();
    }

    private void send() {
        //        String to = "neeraj.bansal589@gmail.com";//change accordingly
        String to = "neeraj.bansal@edifecs.com";
//        String from = "spockk93@gmail.com";//change accordingly
        String from = "spockk93@gmail.com";//change accordingly
//        String password = "vulcan93";
        String password = "vulcan93";

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("spockk93@gmail.com"));
//            message.setRec(Message.RecipientType.CC, "neeraj.bansal589@gmail.com");
            message.addRecipients(Message.RecipientType.TO, "aakash.hingu@round.glass");
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("neeraj.bansal@edifecs.com"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("lakshay.aggarwal@edifecs.com"));
            message.setSubject("aaaaaa");

            Multipart mp = new MimeMultipart();

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent("<b>https://www.youtube.com/watch?v=10-wmV9VinU</b>", "text/html");
            mp.addBodyPart(htmlPart);

//            MimeBodyPart attachment = new MimeBodyPart();
//            File f = new File("C:\\Neeraj\\private\\pan_card_self_attested.pdf");
//            DataSource attachmentDataStream = new FileDataSource(f);
//            attachment.setDataHandler(new DataHandler(attachmentDataStream));
//            attachment.setFileName(f.getName());
//            mp.addBodyPart(attachment);

            message.setContent(mp);

//            Thread.currentThread().setContextClassLoader(getClass().getClassLoader() );
            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (MessagingException mex) {mex.printStackTrace();}

    }
}
