package com.example.isa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name="skills")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    @JsonBackReference //za beskonacnu rekurziju
    private List<User> users;
}