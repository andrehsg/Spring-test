package com.example.np_spring5_tutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/").permitAll()
				.mvcMatchers("/signup",
						"/forgot-password",
						"/reset-password/*").permitAll()
				.mvcMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();
	}
	
	/*
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) 
	      throws Exception {
	        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth.inMemoryAuthentication()
	          .withUser("spring")
	          .password(encoder.encode("secret"))
	          .roles("USER");
	    }
	    */
	// @formatter:on
    
   
    @Bean
    public PasswordEncoder passwordEncoder () {
	return new BCryptPasswordEncoder() ;
	
	
    }
    
    
    

	/*
    
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").permitAll()
			.and().
			logout().permitAll();
	}
	
	*/
	
	/*
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    */
	    
	    
	    
	

}
