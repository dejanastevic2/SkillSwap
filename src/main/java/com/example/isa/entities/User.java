package com.example.isa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity //kaze springu da postoji tabela u bazi
@Table(name="useres")
@Data //getteri i setteri su automatski setovani



public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //da baza automatski generise ID, ako imam Id=1 pa Id=2 onda ce automatski da postoji i Id=3
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private java.util.List<Skill> skills;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;




}
