package com.example.np_spring5_tutorial.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Bean
	//@Profile("dev")
	@ConditionalOnProperty(name = "spring.mail.host", havingValue="foo", matchIfMissing=true)
	public IMailSender mockMailSender () {
		
		return new MockMailSender();
	}
	
	@Bean
	//@Profile("!dev")
	@ConditionalOnProperty(name = "spring.mail.host")
	public IMailSender smtpMailSender (JavaMailSender javaMailSender) {
		
		return new SmtpMailSender(javaMailSender);
	}

}
