package br.com.centerville.churrasqueira.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

import br.com.centerville.churrasqueira.commands.UserCommand;
import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.services.UserDetailsServiceImpl;
import br.com.centerville.churrasqueira.services.UserService;

@Controller

@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class UserController {
    
    private UserService usrService;
    private static Log log = LogFactory.getLog(UserController.class);
    
    
    public UserController(UserService usrService) {
	
	this.usrService = usrService;
    }
    
    @ResponseBody
    @GetMapping(value = "/testee"
    )
    public ResponseEntity<Boolean> asdsad() {
	
	ProcessBuilder pb = new ProcessBuilder("icat_v1_02.sh", "asd", "aaa");
	 Map<String, String> env = pb.environment();
	/* env.put("VAR1", "asd");
	 env.remove("OTHERVAR");
	 env.put("VAR2", env.get("VAR1") + "suffix");
	 */
	 //pb.directory(new File("myDir"));
	 try {
	    Process p = pb.start();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return new ResponseEntity<>(true, HttpStatus.OK);

    }
    
    @GetMapping(value = "/index")
    public String indexPage(){
	
        return "index.html";

    }
    
    @ResponseBody
    @PostMapping(value = "/novoCondomino"
    )
    public ResponseEntity<User> createUser(@RequestBody UserCommand newUser) {
	
        User user = usrService.createUser(newUser.toUser());
	return new ResponseEntity<>(user, HttpStatus.OK);

    }
    
    @ResponseBody
    @GetMapping("/login/{apartamento}/{password}")
    public ResponseEntity<User> doLogIn(@PathVariable int apartamento, @PathVariable String password){
	log.info("/loggin in user " + apartamento);
        User user = usrService.logUserIn(apartamento, password);
        return new ResponseEntity<>(user, HttpStatus.OK);

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
