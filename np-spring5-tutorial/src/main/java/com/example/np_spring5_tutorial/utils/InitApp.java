package com.example.np_spring5_tutorial.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.np_spring5_tutorial.services.UserServiceImpl;

@Component
public class InitApp implements CommandLineRunner {

    private static Log log = LogFactory.getLog(InitApp.class);
  
    @Override
    public void run(String... arg0) throws Exception {
	
	
	log.info("Inside RUN method");
	
    }

}
