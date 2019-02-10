package com.example.np_spring5_tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


public class SmtpMailSender implements IMailSender {
	
	private static Log log = LogFactory.getLog(MockMailSender.class);
	private JavaMailSender emailSender;

	

	public SmtpMailSender(JavaMailSender emailSender) {
	
		this.emailSender = emailSender;
	}



	@Override
	public void sendMail(String to, String subject, String body) {
		
		log.info("Sending STMTP to "+ to);
		log.info("With subject"+ subject);
		log.info("With body"+ body);
		
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(body);
        
        try {
        	emailSender.send(message);
        }
        
        catch (Exception e) {
        	
        	log.info(e.getMessage());
        }
		
	
		
	}
	
	
}