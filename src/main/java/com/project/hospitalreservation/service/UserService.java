package com.project.hospitalreservation.service;

import com.project.hospitalreservation.dto.UserDto;
import com.project.hospitalreservation.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    Long registerUser(UserDto dto);
    Optional<UserEntity> findUserByUsername(String id);
    boolean checkUserValid(UserDto userDto);
}
