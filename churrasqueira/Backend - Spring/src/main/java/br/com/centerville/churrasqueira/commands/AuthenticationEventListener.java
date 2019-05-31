package br.com.centerville.churrasqueira.commands;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
/*
@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

    
    private static Log logger = LogFactory.getLog(AuthenticationEventListener.class);

   public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
      if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
         // ignores to prevent duplicate logging with AuthenticationSuccessEvent
         return;
      }
      org.springframework.security.core.Authentication authentication = authenticationEvent.getAuthentication();
      String auditMessage = "Login attempt with username: " + authentication.getName() + "\t\tSuccess: " + authentication.isAuthenticated();
      logger.info(auditMessage);
   }


}
 */