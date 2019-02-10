package com.example.np_spring5_tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	/*
	  @Override
	  public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/views/jsp/", ".jsp");
	  }
	  */
	
	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	      //this will map uri to jsp view directly without a controller
	      registry.addViewController("/")
	              .setViewName("home");
	      registry.addViewController("/login")
              		.setViewName("login");
	      
	  
	  }

}
