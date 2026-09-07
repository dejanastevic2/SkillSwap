package com.example.isa.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class) //za ovu anotaciju korisit ContactNumberValidator klasu
@Target( {ElementType.METHOD,ElementType.FIELD} ) //kaze gde anotacije Sme da se koristi, znaci nad poljima metod i nad poljima field moze da se koristi
@Retention(RetentionPolicy.RUNTIME) //anotacija postoji dok program radi

public interface ContactNumberConstraint {
    String message() default "Invalid Contact Number"; //default poruka ako validacija padne
    Class<?>[] groups() default{}; //koristi se za grupisanje validacija
    Class<?extends Payload>[] playload() default() //dodatni metadata za ispis greske, napredna validacija
}
