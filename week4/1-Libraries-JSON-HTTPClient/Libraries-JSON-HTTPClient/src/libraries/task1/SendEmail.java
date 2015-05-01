package libraries.task1;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {
	
	public static void main(String[] args) throws EmailException{
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("kon.gif");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Horse bites a man");
		attachment.setName("Horse");
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("goderex@gmail.com", "*********"));
		email.setSSLOnConnect(true);
		email.addTo("teodor.m.stamenov@gmail.com");
		email.setFrom("goderex@gmail.com");
		email.setSubject("Crazy horse");
		email.setMsg("Test");
		
		email.attach(attachment);
		
		email.send();
	}
}
