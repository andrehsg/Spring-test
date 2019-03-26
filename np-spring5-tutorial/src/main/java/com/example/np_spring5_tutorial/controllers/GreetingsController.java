package com.example.np_spring5_tutorial.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.np_spring5_tutorial.utils.MyUtils;

@RestController
public class GreetingsController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/greetings")
    public Greetings greetings (@RequestParam(value="name", defaultValue="World") String name) {

  		
  		/* Will print a JSON Object */
  		return new Greetings(counter.incrementAndGet(),
                        String.format(template, name));
  		
    }

}
