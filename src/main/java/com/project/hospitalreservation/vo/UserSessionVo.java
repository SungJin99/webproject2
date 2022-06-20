package com.project.hospitalreservation.vo;

import com.project.hospitalreservation.dto.UserRole;
import com.project.hospitalreservation.entity.UserEntity;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserSessionVo implements Serializable {
    private final String username;
    private final String password;
    private final String name;
    private final String phone;
    private final UserRole role;

    // Entity -> Vo
    public UserSessionVo(UserEntity user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.name = user.getName();
        this.role = user.getRole();
    }
}
