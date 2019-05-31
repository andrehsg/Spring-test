package br.com.centerville.churrasqueira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import br.com.centerville.churrasqueira.models.User;

public interface UserService {
    User createUser(User user);
    void afterApplicationReady(ApplicationReadyEvent event);
    User getUsers(int id);
    List<User> getAllUsers();
    public User logUserIn (int apto, String password);

}
