package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    List<UserEntity> getAllUser();

    UserEntity createUser(UserEntity user);

    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}
