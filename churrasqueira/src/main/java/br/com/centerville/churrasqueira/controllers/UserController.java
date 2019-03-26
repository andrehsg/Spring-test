package br.com.centerville.churrasqueira.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.services.UserDetailsServiceImpl;
import br.com.centerville.churrasqueira.services.UserService;

@Controller
@RequestMapping(value = "/api/")
public class UserController {
    
    private UserService usrService;
    private static Log log = LogFactory.getLog(UserController.class);
    
    
    public UserController(UserService usrService) {
	
	this.usrService = usrService;
    }
    
    
    @GetMapping(value = "/index")
    public String indexPage(){
	
        return "index.html";

    }
    
    /*
    @ResponseBody
    @PostMapping(value = "/novoCondomino", headers = {
    "content-type=application/json" })
    public User createUser(@RequestBody User newUser){
	
        return usrService.createUser(newUser);

    }
    */
    
    @ResponseBody
    @PostMapping(value = "/novoCondomino")
    public User createUser(@ModelAttribute User newUser){
	
        return usrService.createUser(newUser);

    }
    
    @ResponseBody
    @GetMapping("/condominos/{id}")
    public User seeUser(@PathVariable int id){
	log.info("/find one " + usrService.getUsers(id));
        return usrService.getUsers(id);

    }
    
    @ResponseBody
    @GetMapping("/condominos")
    public List<User> allUsers(){
	log.info("/findall " + usrService.getAllUsers());
        return usrService.getAllUsers();

    }

}
