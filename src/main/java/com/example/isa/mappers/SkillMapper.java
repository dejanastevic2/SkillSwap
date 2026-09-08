package com.example.isa.mappers;

import com.example.isa.entities.Skill;
import com.example.isa.models.SkillModel;

import java.util.ArrayList;
import java.util.List;

public class SkillMapper {

    public static SkillModel toModel(Skill entity) {
        return SkillModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static List<SkillModel> toModelList(List<Skill> entities) {
        var list = new ArrayList<SkillModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }

        return list;
    }
}