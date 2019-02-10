package com.example.np_spring5_tutorial.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.example.np_spring5_tutorial.repositories.UserRepository;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserRepository userRepo;
   
    public UniqueEmailValidator(UserRepository userRepo) {
	this.userRepo = userRepo;
    }


    @Override
    public void initialize(UniqueEmail arg0) {
	// TODO Auto-generated method stub
	
    }
    
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
	// TODO Auto-generated method stub
	return !userRepo.findByEmail(email).isPresent();
    }



}
