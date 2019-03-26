package br.com.centerville.churrasqueira.controllers;

import java.security.Policy.Parameters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.*;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.database.FirebaseDatabase;

import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.services.UserService;
import br.com.centerville.churrasqueira.services.UserServiceImpl;

@RestController
public class TestController {
    
    private UserService usrService;
    
    public TestController(UserService usrService) {
	
	this.usrService = usrService;
    }
    @RequestMapping(value = "/loginza", method = RequestMethod.GET)
    
    public ResponseEntity<Object> restCall() throws Exception {

	/*
	try {
        usrService.createUser(new User());
        return ResponseEntity.status(HttpStatus.OK).body("some body");
	}
	
	catch (Exception e) {
	 e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.FORBIDDEN).body("some body failure");
	}
	
	*/
	return ResponseEntity.status(HttpStatus.OK).body("200 OK");
	

        

    }

}
