package com.example.np_spring5_tutorial.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.np_spring5_tutorial.services.UserDetailsServiceImpl;

@Entity
/* Index to ensure email index is unique */
@Table(name="usr", indexes = {
	@Index(columnList = "email", unique = true)
})

public class User implements UserDetails {
    
   public static enum Role { 
       UNVERIFIED, ADMIN, BLOCKED
   }
   
   private static Log log = LogFactory.getLog(User.class);
    
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="id")
 private Long id;
 
 @Column(name="name", nullable = false, length = 250)
 private String name;
 
 @Column(name="email", nullable = false, length = 250)
 private String email;
 
 @Column(name="password", nullable = false)
 private String password;
 
 @ElementCollection(fetch = FetchType.EAGER)
 @Enumerated(EnumType.STRING)
 private Collection<Role> roles = new HashSet<Role>();

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    log.info("name: " + name);
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

@Override
public String getPassword() {
    log.info("password: " + password);
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public Collection<Role> getRoles() {
    return roles;
}

public void setRoles(Collection<Role> roles) {
    this.roles = roles;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    
    return roles.stream()
		.map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
		.collect(Collectors.toSet());
}

@Override
public String getUsername() {
    
    return this.email;
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
