package com.example.np_spring5_tutorial.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NotBlank
@Size(min=6, max=100)
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Password {
    
    String message() default "{duplicateEmail}";
    
    Class[] groups() default {};
    
    Class[] payload() default {};

}
