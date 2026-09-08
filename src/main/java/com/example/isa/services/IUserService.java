package com.example.isa.services;

import com.example.isa.models.UserModel;
import com.example.isa.models.UserPageModel;
import com.example.isa.models.UserSkillsModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserPageModel findPagedList(PageRequest pageRequest);
    UserModel create(UserModel model);
    UserModel update(UserModel model);
    List<UserSkillsModel> findUserSkillsAll();
}