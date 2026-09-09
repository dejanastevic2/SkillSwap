package com.example.isa.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.isa.entities.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name="password")
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private List<Skill> skills;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private List<Role> roles;

    // Metoda za dobijanje uloga u Spring Security-ju
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (roles != null) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            }
        }
        return authorities;
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}