package com.example.np_spring5_tutorial.services;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.np_spring5_tutorial.commands.UserCommand;
import com.example.np_spring5_tutorial.controllers.SignupController;
import com.example.np_spring5_tutorial.domain.User;
import com.example.np_spring5_tutorial.domain.User.Role;
import com.example.np_spring5_tutorial.mail.IMailSender;
import com.example.np_spring5_tutorial.repositories.UserRepository;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class UserServiceImpl implements UserService {
    
    @Value ("${application.admin.email:admin@example.com}")
    private String adminMail;
    
    @Value ("${application.admin.name:fulano}")
    private String adminName;
    
    @Value ("${application.admin.password:root}")
    private String adminPassword;
    
    
    private UserRepository usrRepo;
    private PasswordEncoder passwordEncoder;
    private static Log log = LogFactory.getLog(UserServiceImpl.class);
    
    
    @Autowired
    //@Qualifier("mockMailSender")
    private IMailSender im;

    
    public UserServiceImpl(UserRepository usrRepo, PasswordEncoder passwordEncoder
	    ) {
	
	this.usrRepo = usrRepo;
	this.passwordEncoder = passwordEncoder;
    }
    
    /*
    public UserServiceImpl(UserRepository usrRepo
	    ) {
	
	this.usrRepo = usrRepo;
    }
    */
    
    @PostConstruct
    public void init () {
	
	log.info("Post Construct");
	
    }

    @Override
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady (ApplicationReadyEvent event) {
	
	log.info("Inside afterAppReady");
	
	this.im.sendMail("aaa", "bbb", "ccc");
	
	if ( !usrRepo.findByEmail(adminMail).isPresent() ) {
        	User usr = new User();
        	//BCryptPasswordEncoder bc = new BCryptPasswordEncoder(10);
        	usr.setEmail(adminMail);
        	usr.setName(adminName);
        	usr.getRoles().add(Role.ADMIN);
        	//BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        	//String encoded = bcrypt.encode(adminPassword);
        	usr.setPassword(passwordEncoder.encode( adminPassword ));
        	//usr.setPassword(encoded);
        	//log.info("Does it match ? " + bcrypt.matches(adminPassword,encoded) + " plainPass:"+adminPassword + "plainMail" + adminMail);
        	usrRepo.save(usr);
	
	}
	
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void signUp(UserCommand usr) {
	User user = usr.toUser();
	String encoded = passwordEncoder.encode(user.getPassword());
	//user.setPassword(passwordEncoder.encode( user.getPassword()) );
	user.setPassword(encoded);
	user.getRoles().add(Role.UNVERIFIED);
	this.usrRepo.save(user);
	
    }

}
