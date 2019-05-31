package br.com.centerville.churrasqueira.services;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Log log = LogFactory.getLog(UserDetailsServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	log.debug("finding " + username);
	UserDetails ud = userRepository.findByApartamento(Integer.parseInt(username));
	//UserDetails ud = userRepository.findById(Integer.parseInt(username)).orElseThrow(() -> new UsernameNotFoundException(username));
	return ud;
				
        
	
    }

}
