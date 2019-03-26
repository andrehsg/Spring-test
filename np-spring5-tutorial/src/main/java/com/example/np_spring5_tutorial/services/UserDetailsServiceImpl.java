package com.example.np_spring5_tutorial.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.np_spring5_tutorial.controllers.SignupController;
import com.example.np_spring5_tutorial.repositories.UserRepository;

@Service
public  class UserDetailsServiceImpl implements UserDetailsService {
	
        private static Log log = LogFactory.getLog(UserDetailsServiceImpl.class);
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    
	   
	    log.info("loggin in " + username);
	    

		return userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
}