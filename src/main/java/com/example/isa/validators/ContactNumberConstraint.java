package com.example.isa.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class) // za ovu anotaciju koristi ContactNumberValidator klasu
@Target({ElementType.METHOD, ElementType.FIELD}) // kaže gde anotacija sme da se koristi, znači nad poljima method i nad poljima field može da se koristi
@Retention(RetentionPolicy.RUNTIME) // anotacija postoji dok program radi
public @interface ContactNumberConstraint {
    String message() default "Invalid Contact Number"; // default poruka ako validacija padne
    Class<?>[] groups() default {}; // koristi se za grupisanje validacija
    Class<? extends Payload>[] payload() default {}; // dodatni metadata za ispis greške, napredna validacija
}