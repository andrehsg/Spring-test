package com.example.np_spring5_tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.np_spring5_tutorial.utils.MyUtils;

@Controller
public class HelloController {

@RequestMapping("/hello")
	public String hello (Model model) {
    
      		//model.addAttribute("name", "Andre");
      		model.addAttribute("name", MyUtils.getMessage("name"));
		return "hello";
	}

/* Another RequestMapping with PathVariable and @RequestParam usage examples for your studies 
 * 
 * http://localhost:8080/hello/5?name=Andre
 * */
@RequestMapping("/hello/{id}")
    public String hello (
	Model model,
    	@PathVariable("id") int id,
    	@RequestParam(value="name", required = false) String name) {
    
    		
    		model.addAttribute("name", name);
    		model.addAttribute("id", id);
    		
    		return "hello-id";
    	}



}
