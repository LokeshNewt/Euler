import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Created by neerbans on 10/11/2017.
 */
public class TestEmail {

    public static void main (String [] args) {

        Session session;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.user", "edifecs.qa@gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        session = Session.getDefaultInstance(properties);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("edifecs.qa@gmail.com"));
//            msg.setRecipients(Message.RecipientType.TO, "neeraj.bansal@edifecs.com");
//            msg.addRecipients(Message.RecipientType.TO, "neeraj.bansal@edifecs.com");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("neeraj.bansal@edifecs.com"));
            msg.setSubject("Subject: Test Email6");

            // 3.
//            msg.setText("hello");


            // 1. BODY
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<b>Hello, this is example of sending email</b>", "text/html");

            // 2.Attach Body
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);  //add body


            // ATTCHEMNST
            BodyPart attachment = new MimeBodyPart();
            String file = "C:\\Neeraj\\private\\pan_card_self_attested.pdf";
            File f = new File(file);
            DataSource source = new FileDataSource(f);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(f.getName() );
            multipart.addBodyPart(attachment);  //add attachment

            msg.setContent(multipart);
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), "Edifecs123");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

}
