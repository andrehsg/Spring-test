package br.com.centerville.churrasqueira.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usr", indexes = {
	@Index(columnList = "apto", unique = true)
})
public class User implements UserDetails {
    
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uuid")
    private int id;
    */
    
    @Id
    @NotNull
    @Column(name="apto")
    private int apto;
    
    @NotNull
    @Column(name="nome")
    private String condomino;
    
    @NotNull
    @Column(name="senha")
    private String password;
  
  public void setPassword(String password) {
        this.password = password;
    }

   public int getApartamento() {
        return apto;
    }

    public void setApartamento(int apartamento) {
        this.apto = apartamento;
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
	// TODO Auto-generated method stub
	return String.valueOf(this.apto);
    }

    @Override
    public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
    }


}


