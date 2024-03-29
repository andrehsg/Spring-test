package com.example.np_spring5_tutorial.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import org.hibernate.validator.constraints.Email;

@Constraint(validatedBy=UniqueEmailValidator.class)
@NotBlank(message="{blankEmail}")
@Email
@Size(min=1, max=100, message="{mailSizeError}")
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
    
    String message() default "{duplicateEmail}";
    
    Class[] groups() default {};
    
    Class[] payload() default {};

}
