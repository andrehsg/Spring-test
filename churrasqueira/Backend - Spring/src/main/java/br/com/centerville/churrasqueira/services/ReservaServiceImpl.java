package br.com.centerville.churrasqueira.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.centerville.churrasqueira.models.Reserva;
import br.com.centerville.churrasqueira.models.User;
import br.com.centerville.churrasqueira.repositories.ReservaRepository;
import br.com.centerville.churrasqueira.repositories.UserRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

    private static Log log = LogFactory.getLog(ReservaServiceImpl.class);
    private ReservaRepository reservaRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public ReservaServiceImpl (ReservaRepository reservaRepository) {
	log.error("Inject");
	this.reservaRepository = reservaRepository;
    }
    
    
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady (ApplicationReadyEvent event) {
	/*
	User u = new User();
	u.setApartamento(99);
	u.setCondomino("Fulano");
	u.setPassword(this.passwordEncoder.encode("root"));
	
	Reserva res = new Reserva();
	res.setApartamento(u);
	res.setDate(LocalDate.of(2019, 6, 15));

	this.createReserva(res);
	*/
	
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Reserva createReserva (Reserva res) {

	   return reservaRepository.save(res);
        
        }


    @Override
    public List<Reserva> getReserva() {
	log.debug("getReserva");
	List<Reserva> listReservas;
	try {
	    listReservas = reservaRepository.findAll();
	}
	
	catch (Exception e) {
	    e.printStackTrace();
	    throw new ResponseStatusException (HttpStatus.BAD_REQUEST, e.getMessage());
     
	}
	
        if (listReservas == null) {
          
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found");
        }
        return listReservas;

    }

}
