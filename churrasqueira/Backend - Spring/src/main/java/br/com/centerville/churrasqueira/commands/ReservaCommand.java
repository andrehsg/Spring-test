package br.com.centerville.churrasqueira.commands;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.centerville.churrasqueira.models.Reserva;
import br.com.centerville.churrasqueira.models.User;



public class ReservaCommand {
    

    public ReservaCommand() {
	
    }

    @NotBlank
    @Size(min=1, max=3)
    private int apartamento;
    
    @NotNull
    @Size(min=6, max=12)
    private LocalDate date;
    

    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public int getApartamento() {
        return apartamento;
    }


    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }




    public Reserva toReserva(User usr) {
	
	Reserva res = new Reserva();
	res.setApartamento(usr);
	res.setDate(this.date);
	return res;
    }

}
