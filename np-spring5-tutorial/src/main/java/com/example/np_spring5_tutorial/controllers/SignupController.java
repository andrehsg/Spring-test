package com.example.np_spring5_tutorial.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.np_spring5_tutorial.commands.UserCommand;
import com.example.np_spring5_tutorial.mail.MockMailSender;
import com.example.np_spring5_tutorial.services.UserService;
import com.example.np_spring5_tutorial.utils.MyUtils;

@Controller
public class SignupController {
    
    private UserService usrService;
    
    public SignupController(UserService usrService) {
	
	this.usrService = usrService;
    }

    private static Log log = LogFactory.getLog(SignupController.class);
    // @RequestMapping(value="/signup", method=RequestMethod.POST)
    	@PostMapping("/signup")
	public String doSignup (
        		@Validated @ModelAttribute("user") UserCommand userCommand,
        		BindingResult result,
        		RedirectAttributes redirectAtt
		) {
        	    	if (result.hasErrors()) {
        	    	    log.info("result validation: " + result);
        	    	    return "signup";
    	    	}
    		log.info("name: " + userCommand.getName() + " ,email: " + userCommand.getEmail() + " ,password: " + userCommand.getPassword());
    		
    		this.usrService.signUp(userCommand);
    		MyUtils.flashMessage(redirectAtt, "success", "successMsg");
    		
		return "redirect:/";
	}

    	//@RequestMapping(value="/signup", method=RequestMethod.GET)
	@GetMapping("/signup")
	public String signupGet (Model model){
	    model.addAttribute("user", new UserCommand());
	    return "signup";
	}
}
