package br.com.centerville.churrasqueira.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	/*
         // uma vez tirei isso e deu pau
	  @Override
	  public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/views/", ".html");
	  }
	  
	
	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	      //this will map uri to jsp view directly without a controller
	      registry.addViewController("/")
	              .setViewName("index.html");
	      
	  
	  }
	  
	  */

}
