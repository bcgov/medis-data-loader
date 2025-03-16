package ca.bc.gov.hlth.medis.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Autowired
    public JavaMailSender emailSender;
	
	/**
	 * Sends an email.
	 * @param recipients Semi-colon delimited list of recipients
	 * @param subject
	 * @param text
	 */
	public void sendNotificationEmail(String from, String recipients, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage(); 
		
		String[] to = StringUtils.split(recipients, ";");
		message.setFrom(from);
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
        
        logger.debug("Email sent");
	}

}
