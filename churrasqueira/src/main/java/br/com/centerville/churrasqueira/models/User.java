package br.com.centerville.churrasqueira.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user", indexes = {
	@Index(columnList = "apartamento", unique = true)
})
public class User implements UserDetails {
    
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uuid")
    private int id;
    */
    
    @Id
    @Column(name="apartamento")
    private int apartamento;
    
    @JsonIgnore
    @OneToOne(mappedBy = "apartamento")
    private Reserva reserva;
    
    @Column(name="nome")
    private String condomino;
    
    @Column(name="senha")
    private String password;
  
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public String getCondomino() {
        return condomino;
    }

    public void setCondomino(String condomino) {
        this.condomino = condomino;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getPassword() {
	
	return this.password;
    }

    @Override
    public String getUsername() {

	return String.valueOf(this.apartamento);
    }

    @Override
    public boolean isAccountNonExpired() {

	return true;
    }

    @Override
    public boolean isAccountNonLocked() {

	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

	return true;
    }

    @Override
    public boolean isEnabled() {

	return true;
    }


}


