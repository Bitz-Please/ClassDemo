import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@SessionScoped
@ManagedBean (name = "emailbean")
public class EmailBean {
 
	
 
    final String username = "bitspleasemoviematic@gmail.com";
    final String password = "cs2340project";
    Properties props;
    
    public EmailBean() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); 
    }

    
    public void sendEmail(User user, String content) {
       Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Password Recovery Bits Please Movie Matic");
            message.setText("Dear " + user.getUsername() + ","
                    + "\n\n your password is " + user.getPassword() + ", idiot.");

            Transport.send(message);
        } catch (MessagingException e) {
                throw new RuntimeException(e);
        } 

    }
}