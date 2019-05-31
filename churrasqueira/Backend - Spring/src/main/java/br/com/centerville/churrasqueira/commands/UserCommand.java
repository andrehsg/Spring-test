package br.com.centerville.churrasqueira.commands;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.centerville.churrasqueira.models.User;



public class UserCommand {
    

    public UserCommand() {
	
    }

    @NotBlank
    @Size(min=2, max=3)
    private int apto;
    
    @NotBlank
    @Size(min=1, max=50)
    private String condomino;
    
    @NotBlank
    @Size(min=6, max=12)
    private String password;
    
    
    public int getApto() {
        return apto;
    }


    public void setApto(int apto) {
        this.apto = apto;
    }


    public String getCondomino() {
        return condomino;
    }


    public void setCondomino(String condomino) {
        this.condomino = condomino;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
	
	User usr = new User();
	usr.setApartamento(this.apto);
	usr.setCondomino(this.condomino);;
	usr.setPassword(this.password);
	return usr;
    }

}
