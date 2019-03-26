package com.example.np_spring5_tutorial.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.example.np_spring5_tutorial.commands.UserCommand;

public interface UserService {

    void signUp(UserCommand usr);
    void afterApplicationReady(ApplicationReadyEvent event);
}
