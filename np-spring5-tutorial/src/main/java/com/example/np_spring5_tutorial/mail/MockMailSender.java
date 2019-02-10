package com.example.np_spring5_tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class MockMailSender implements IMailSender {
	
	private static Log log = LogFactory.getLog(MockMailSender.class);

	@Override
	public void sendMail(String to, String subject, String body) {
		
		log.info("Sending mock to " + to);
		log.info("With subject" + subject);
		log.info("With body" + body);
		
	
		
	}

}
