package com.example.isa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_profiles")
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}