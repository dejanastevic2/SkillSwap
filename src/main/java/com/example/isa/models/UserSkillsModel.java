package com.example.isa.models;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class UserSkillsModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<SkillModel> skills;
}