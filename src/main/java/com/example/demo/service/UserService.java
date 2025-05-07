package com.example.demo.service;

import com.example.demo.dto.user.request.CreateUserDto;
import com.example.demo.entity.UserEntity;

import java.util.List;


public interface UserService {
    List<UserEntity> getAllUser();

    UserEntity createUser(UserEntity user);
}
