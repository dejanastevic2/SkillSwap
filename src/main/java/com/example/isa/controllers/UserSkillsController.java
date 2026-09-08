package com.example.isa.controllers;

import com.example.isa.repositories.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin("*")


public class UserSkillsController {
    private final ISkillRepository skillRepository;

    @GetMapping("get-list")
    public List<Skill> getList(){return skillRepository.findAll(); }

}
