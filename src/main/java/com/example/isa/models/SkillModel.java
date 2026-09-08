package com.example.isa.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillModel {
    private Integer id;
    private String name;
}