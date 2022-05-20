/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  models;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 
public class Mail {
    public boolean sendMail(String msg,String emailid,String sub)
    {
        final String username = "vj.mpovs.otp@gmail.com";
		 
 
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, "Ov123@123");
			}
		  });
 
		try 
                {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailid));
			message.setSubject(sub);
			message.setText(msg);
 
			Transport.send(message);
 
			System.out.println("Done");
                        return true;
 
		} catch (MessagingException e) {
			System.out.println(e);
			throw new RuntimeException(e);
                        
		}
 
    }
    
}
