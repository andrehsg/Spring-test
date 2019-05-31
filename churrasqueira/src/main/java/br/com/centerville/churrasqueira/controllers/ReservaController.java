package br.com.centerville.churrasqueira.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.centerville.churrasqueira.commands.ReservaCommand;
import br.com.centerville.churrasqueira.commands.UserCommand;
import br.com.centerville.churrasqueira.models.Reserva;
import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.services.ReservaService;
import br.com.centerville.churrasqueira.services.UserService;

@RestController

@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class ReservaController {
    
    private ReservaService reservaService;
    private UserService usrService;
    
    public ReservaController(ReservaService reservaService, UserService usrService) {
	
 	this.reservaService = reservaService;
 	this.usrService = usrService;
     }
    
    @PostMapping(value = "/novaReserva")
    public ResponseEntity<Reserva> createReserva(@RequestBody ReservaCommand newReserva) {
	
	User usr = usrService.getUsers(99);
        Reserva reserva = reservaService.createReserva(newReserva.toReserva(usr));
	return new ResponseEntity<>(reserva, HttpStatus.OK);

    }
    
    @GetMapping(value = "/getReservas")
    public ResponseEntity<List<Reserva>> getReserva() {
	
	List<Reserva> listReserva = reservaService.getReserva();
	return new ResponseEntity<>(listReserva,HttpStatus.OK);
	


        

    }

}
