package com.example.isa.controllers;

import com.example.isa.entities.Skill;
import com.example.isa.repositories.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("skills")
@RequiredArgsConstructor
@CrossOrigin("*")


public class UserSkillsController {
    private final ISkillRepository skillRepository;

    @GetMapping("get-list")
    public List<Skill> getList(){return skillRepository.findAll(); }

}
