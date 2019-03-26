package com.example.np_spring5_tutorial.commands;

import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.np_spring5_tutorial.domain.User;
import com.example.np_spring5_tutorial.validation.Password;
import com.example.np_spring5_tutorial.validation.UniqueEmail;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/* Classe do tipo command que valida entradas do usuario (UI) para posteriormente ser gravada no banco de dados.
 * Esta funcao de persistencia no banco eh delegada para a layer de services, onde recebe um UserCommand, converte para a classe de dominio (JPA) e grava no banco usando a interface JPARepository  */

public class UserCommand {
    
    @NotBlank
    @Size(min=1, max=100)
    private String name;
    
    @UniqueEmail
    private String email;
    
    @Password
    private String password;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User toUser() {
	
	User usr = new User();
	usr.setEmail(email);
	usr.setName(name);
	usr.setPassword(password);
	return usr;
    }

}
