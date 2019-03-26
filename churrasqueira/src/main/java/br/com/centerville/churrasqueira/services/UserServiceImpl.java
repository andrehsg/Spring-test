package br.com.centerville.churrasqueira.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
    
    
    private UserRepository userRepository;
    private static Log log = LogFactory.getLog(UserServiceImpl.class);
    
    public UserServiceImpl (UserRepository userRepository) {
	
	this.userRepository = userRepository;
    }
    
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady (ApplicationReadyEvent event) {
	
	
	User u = new User();
	u.setApartamento(99);
	u.setCondomino("Fulano");
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	u.setPassword(passwordEncoder.encode("root"));
	this.createUser(u);
	
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User createUser (User user) {
        try {
    	//User u = new User();
    	//u.setApartamento(89);
    	//u.setCondomino("Fulanoss");
    	//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	//u.setPassword(passwordEncoder.encode("root"));
	return userRepository.save(user);
	
        }
        
        catch (Exception e) {
           e.printStackTrace();
           return null;
        
        }
    }
    
    public User getUsers (@PathVariable int apto) {
	log.info("Procurando " + userRepository.findByApto(apto));
	return userRepository.findByApto(apto);
	//return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("username"));
    }
    
    public List<User> getAllUsers () {
	log.info("Procurando todos os condominos.");
	return userRepository.findAll();
    }


    
    


   

}
