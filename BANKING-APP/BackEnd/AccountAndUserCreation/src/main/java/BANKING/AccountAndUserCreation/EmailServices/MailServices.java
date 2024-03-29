package BANKING.AccountAndUserCreation.EmailServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServices {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail(String to, String subject, String body) {
		System.out.println("***************");
		System.out.println(to);
	// Here the below class is used to set reveiver mail-id and subject and message to sent mail
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("EMAIL SEND SUCCESSFULLY");
        return;
    }

}
