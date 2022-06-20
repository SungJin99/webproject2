package com.project.hospitalreservation.dto;

import java.sql.Date;

import com.project.hospitalreservation.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String name;
    private String phone;
    private UserRole role;
    private String gender;
    private Date birth;
    private String address;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .username(username)
                .password(password)
                .name(name)
                .phone(phone)
                .role(UserRole.USER)
                .gender(gender)
                .birth(birth)
                .address(address)
                .build();
    }

    // From Entity -> DTO
    public UserDto(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.name = userEntity.getName();
        this.phone = userEntity.getPhone();
        this.role = userEntity.getRole();
        this.gender=userEntity.getGender();
        this.birth=userEntity.getBirth();
        this.address=userEntity.getAddress();
    }

    // From CustomUserDetails -> DTO
    public UserDto(CustomUserDetails customUserDetails) {
        this.username = customUserDetails.getUsername();
        this.name = customUserDetails.getUserEntity().getName();
        this.phone = customUserDetails.getUserEntity().getPhone();
        this.role = customUserDetails.getUserEntity().getRole();
        this.gender=customUserDetails.getUserEntity().getGender();
        this.birth=customUserDetails.getUserEntity().getBirth();
        this.address=customUserDetails.getUserEntity().getAddress();
    }
}
