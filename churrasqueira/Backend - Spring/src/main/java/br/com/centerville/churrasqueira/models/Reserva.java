package br.com.centerville.churrasqueira.models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservas", indexes = {
	@Index(columnList = "FK_apartamento", unique = true)
})
public class Reserva {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uuid")
    private int id;
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_apartamento", referencedColumnName = "apartamento")
    private User apartamento;
    

    @Column(name="data")
    private LocalDate date;


    public User getApartamento() {
        return apartamento;
    }


    public void setApartamento(User apartamento) {
        this.apartamento = apartamento;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }




    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
  
    


}


