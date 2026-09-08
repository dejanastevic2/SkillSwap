package com.example.isa.services;

import com.example.isa.mappers.UserMapper;
import com.example.isa.mappers.UserSkillsMapper;
import com.example.isa.models.UserModel;
import com.example.isa.models.UserPageModel;
import com.example.isa.models.UserSkillsModel;
import com.example.isa.repositories.IUserRepository;
import com.example.isa.repositories.IUserSkillsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserSkillsRepository userSkillsRepository;

    @Override
    public List<UserModel> findAll() {
        var result = userRepository.findAll();
        return UserMapper.toModelList(result);
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        var result = userRepository.findAll(pageRequest);
        return UserMapper.toModelPagedList(result);
    }

    @Override
    public UserModel create(UserModel model) {
        var entity = UserMapper.toEntity(model);
        return UserMapper.toModel(userRepository.save(entity));
    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model);
        return UserMapper.toModel(userRepository.save(entity));
    }

    @Override
    public List<UserSkillsModel> findUserSkillsAll() {
        var result = userSkillsRepository.findAll();
        return UserSkillsMapper.toModelList(result);
    }
}