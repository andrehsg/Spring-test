package br.com.centerville.churrasqueira.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
    
    
    private UserRepository userRepository;
    private static Log log = LogFactory.getLog(UserServiceImpl.class);
    private Encoder passwordEncoder = Base64.getEncoder();
    
    public UserServiceImpl (UserRepository userRepository) {
	
	this.userRepository = userRepository;
    }
    
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady (ApplicationReadyEvent event) {

	    User u = new User();
	    u.setApartamento(99);
	    u.setCondomino("Fulano");
	    u.setPassword("root");
	    //userRepository.saveAndFlush(u);
	    User uu = this.createUser(u);
	    log.info("User created?" + uu.getPassword());
	    
	
	
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User createUser (User user) {
        try {
            
            MessageDigest md;
	    try {
		md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(user.getPassword().getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		log.info("Hash " + hashtext);
		user.setPassword(hashtext);
	    } catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }


    	if (! userRepository.existsById(user.getApartamento())) {
    	   log.info("User does not exist. Saving ");
	   return userRepository.save(user);
	   
    	  }
    	else
    	    throw new ResponseStatusException (HttpStatus.CONFLICT, "User exists");
        }
        
        catch (IllegalArgumentException e) {
           e.printStackTrace();
           throw new ResponseStatusException (HttpStatus.BAD_REQUEST, e.getMessage());
        
        }
    }
    
    public User logUserIn (int apto, String password) {
	log.info("Procurando " + userRepository.findByApartamento(apto));
	User user = userRepository.findByApartamento(apto);
	if (user == null || !user.getPassword().equals(password))
	    throw new ResponseStatusException (HttpStatus.UNAUTHORIZED, "Bad credentials");
	else return user;
	    

    }
    
    public User getUsers (@PathVariable int apto) {
	log.info("Procurando " + userRepository.findByApartamento(apto));
	return userRepository.findByApartamento(apto);
	//return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("username"));
    }
    
    public List<User> getAllUsers () {
	log.info("Procurando todos os condominos.");
	return userRepository.findAll();
    }


    
    


   

}
