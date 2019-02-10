package com.example.np_spring5_tutorial.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

@Entity
/* Index to ensure email index is unique */
@Table(name="usr", indexes = {
	@Index(columnList = "email", unique = true)
})

public class User {
    
   public static enum Role { 
       UNVERIFIED, ADMIN, BLOCKED
   }
    
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

public Collection<Role> getRoles() {
    return roles;
}

public void setRoles(Collection<Role> roles) {
    this.roles = roles;
}



 
}
