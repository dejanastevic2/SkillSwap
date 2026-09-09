package com.example.isa.mappers;

import com.example.isa.entities.User;
import com.example.isa.models.*;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User toEntity(UserModel model){
        User user=new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        user.setPassword(model.getPassword());

        return user;
    }
    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder) {
        if (model == null) {
            return null;
        }
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));

        return user;
    }
    public static UserModel toModel(User entity){
        return UserModel.builder()   //da bih izbegla set metode, builder to radi za mene
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .contactNumber(entity.getContactNumber()).build();


    }

    public static List<UserModel> toModelList(List<User> entities){
        var list=new ArrayList<UserModel>();
        for (var entity: entities){
            list.add(toModel(entity));
        }
        return list;
    }
    public static UserPageModel toModelPagedList(Page<User> pageEntity){
        return UserPageModel.builder()
                .users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements()).build();
    }




}
