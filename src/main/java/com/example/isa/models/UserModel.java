package com.example.isa.models;

import com.example.isa.validators.ContactNumberConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Integer id;

    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    private String email;

    @ContactNumberConstraint
    private String contactNumber;

    private String password;
}