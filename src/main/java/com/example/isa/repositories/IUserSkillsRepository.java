package com.example.isa.repositories;

import com.example.isa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserSkillsRepository extends JpaRepository<User, Integer> {
}