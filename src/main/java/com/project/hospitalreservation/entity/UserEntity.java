package com.project.hospitalreservation.entity;

import lombok.*;

import java.sql.Date;

import javax.persistence.*;

import com.project.hospitalreservation.dto.UserRole;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "site_user")
public class UserEntity {
    @Id
    @GeneratedValue
    // 내부 분류용 ID
    private long id;

    // 로그인 할 때 ID로 사용 그래서 unique 옵션 넣음.
    @Column(unique = true, length = 100)
    private String username;

    @Column
    private String password;

    @Column
    private String phone;

    @Column(length = 50)
    private String name;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(nullable = false)
    private Date birth;
    
    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;
}
