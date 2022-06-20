package com.project.hospitalreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospitalreservation.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
