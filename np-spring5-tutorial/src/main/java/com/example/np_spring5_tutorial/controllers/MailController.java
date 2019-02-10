package com.example.np_spring5_tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.np_spring5_tutorial.mail.IMailSender;
import com.example.np_spring5_tutorial.mail.MockMailSender;

@RestController
public class MailController {
	
	
	//@Qualifier ("mockMailSender") 
	
	
	@Autowired
	private IMailSender smtp;
	@RequestMapping("/mail")
	public String hello () {
		
		this.smtp.sendMail("andrehsg@hotmail.com", "A test subject", "A test body");
		
		return "mail sent: ";
	}

}
