package com.project.hospitalreservation.service;

import com.project.hospitalreservation.dto.UserDto;
import com.project.hospitalreservation.entity.UserEntity;
import com.project.hospitalreservation.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long registerUser(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userRepository.save(userDto.toEntity()).getId();
    }

    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    /*
        입력한 내용이 제대로 되었는지 확인하는 로직.
        - ID 중복 확인
        - ID는 영문 또는 숫자로 구성되어 있는지?
        - 이름이 50자 이내인지
        - 전화번호 뒷 자리는 8자리 내인지?
        - 비밀번호는 영문, 특문 포함이 되어 있으며, 8자 이상인지?
    */
    public boolean checkUserValid(UserDto userDto) {
        return false;
    }
}
