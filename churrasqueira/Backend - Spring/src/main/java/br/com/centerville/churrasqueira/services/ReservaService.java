package br.com.centerville.churrasqueira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import br.com.centerville.churrasqueira.models.Reserva;
import br.com.centerville.churrasqueira.models.User;

public interface ReservaService {
    
    Reserva createReserva(Reserva res);
    List<Reserva> getReserva();


}
