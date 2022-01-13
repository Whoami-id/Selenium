
package reporter;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import configuratorTestSuite2.ReadPropertyFile;

public class Email {
    final static ReadPropertyFile propertyFile = new ReadPropertyFile();

    public static void sendEmail(final String recepient, final String pathChromePdf, final String pathEdgePdf,
            final String pathOperaPdf) {

        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.outlook.com");
        properties.put("mail.smtp.port", "587");

        final Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(propertyFile.getEmailSender(), propertyFile.getPasswordSender());
            }
        });

        final Message message = prepareMessage(session, propertyFile.getEmailSender(), recepient, pathChromePdf,
                pathEdgePdf, pathOperaPdf);
        try {
            Transport.send(message);
        } catch (final MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public static Message prepareMessage(final Session session, final String account, final String recepient,
            final String pathChromePdf, final String pathEdgePdf, final String pathOperaPdf) {
        final Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(account));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Report of configurator tests");
            final Multipart emailContent = new MimeMultipart();
            final MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("You get the report of configurator test as PDF data");
            final MimeBodyPart pdfAttachmentChrome = new MimeBodyPart();
            final MimeBodyPart pdfAttachmentEdge = new MimeBodyPart();
            final MimeBodyPart pdfAttachmentOpera = new MimeBodyPart();
            pdfAttachmentChrome.attachFile(System.getProperty("user.dir") + pathChromePdf);
            pdfAttachmentEdge.attachFile(System.getProperty("user.dir") + pathEdgePdf);
            pdfAttachmentOpera.attachFile(System.getProperty("user.dir") + pathOperaPdf);
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachmentChrome);
            emailContent.addBodyPart(pdfAttachmentEdge);
            emailContent.addBodyPart(pdfAttachmentOpera);
            message.setContent(emailContent);
            return message;
        } catch (final AddressException ex) {
            ex.printStackTrace();
        } catch (final MessagingException ex) {
            ex.printStackTrace();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
