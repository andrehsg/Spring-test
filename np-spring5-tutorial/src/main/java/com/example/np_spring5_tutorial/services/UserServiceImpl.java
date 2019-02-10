package com.example.np_spring5_tutorial.services;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.np_spring5_tutorial.commands.UserCommand;
import com.example.np_spring5_tutorial.controllers.SignupController;
import com.example.np_spring5_tutorial.domain.User;
import com.example.np_spring5_tutorial.domain.User.Role;
import com.example.np_spring5_tutorial.repositories.UserRepository;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class UserServiceImpl implements UserService {
    
    @Value ("${application.admin.email: admin@example.com}")
    private String adminMail;
    
    @Value ("${application.admin.name : First admin}")
    private String adminName;
    
    @Value ("${application.admin.password : password}")
    private String adminPassword;
    
    
    private UserRepository usrRepo;
    private static Log log = LogFactory.getLog(UserServiceImpl.class);

    public UserServiceImpl(UserRepository usrRepo) {
	
	this.usrRepo = usrRepo;
    }
    
    @PostConstruct
    public void init () {
	
	log.info("Post Construct");
	
    }

    @Override
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterAppReady (ApplicationReadyEvent event) {
	
	log.info("Inside afterAppReady");
	
	if ( !usrRepo.findByEmail(adminMail).isPresent() ) {
        	User usr = new User();
        	usr.setEmail(adminMail);
        	usr.setName(adminName);
        	usr.setPassword(adminPassword);
        	usrRepo.save(usr);
	
	}
	
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void signUp(UserCommand usr) {
	User user = usr.toUser();
	user.getRoles().add(Role.UNVERIFIED);
	this.usrRepo.save(user);
	
    }

}
