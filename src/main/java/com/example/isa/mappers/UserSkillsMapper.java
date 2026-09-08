package com.example.isa.mappers;

import com.example.isa.entities.User;
import com.example.isa.models.UserSkillsModel;

import java.util.ArrayList;
import java.util.List;

public class UserSkillsMapper {

    public static UserSkillsModel toModel(User entity) {
        return UserSkillsModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .skills(SkillMapper.toModelList(entity.getSkills()))
                .build();
    }

    public static List<UserSkillsModel> toModelList(List<User> entities) {
        var list = new ArrayList<UserSkillsModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }

        return list;
    }
}