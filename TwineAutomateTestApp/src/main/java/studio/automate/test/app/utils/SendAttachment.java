package studio.automate.test.app.utils;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import studio.automate.test.app.model.EmailModel;

public class SendAttachment{

private static final Logger logger = Logger.getLogger(SendAttachment.class.getName());
	public void sendEmail(EmailModel emailModel) throws AddressException, MessagingException {

        String emailHost = emailModel.getEmailHost();
        String fromUser = emailModel.getFromEmailUser();
        String fromUserEmailPwd = emailModel.getFromEmailpassword();
        String emailPort = emailModel.getEmailPort();
        String toAddrs = emailModel.getToEmail();
        //String[] toEmails = toAddrs.split(";");
        final String username = fromUser;  // like yourname@outlook.com
        final String password = fromUserEmailPwd;   // password here

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.port", emailPort);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddrs));   // like inzi769@gmail.com

            message.setSubject(emailModel.getEmailSubject());
            message.setContent(emailModel.getEmailBody(), "text/html");//for a html email

            Transport.send(message);

            logger.info("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
        
    
}