package com.example.isa.controllers;

import com.example.isa.models.UserModel;
import com.example.isa.models.UserPageModel;
import com.example.isa.models.UserSkillsModel;
import com.example.isa.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final IUserService userService;

    @GetMapping("get-list")
    public List<UserModel> getList() {
        return userService.findAll();
    }

    @GetMapping("get-user-skills-list")
    public List<UserSkillsModel> getUserSkillsList() {
        return userService.findUserSkillsAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return userService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.update(userModel), HttpStatus.CREATED);
    }
}