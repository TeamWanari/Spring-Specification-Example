package com.wanari.specification.example.service;

import com.wanari.specification.example.controller.dto.UserDto;
import com.wanari.specification.example.controller.mapper.UserMapper;
import com.wanari.specification.example.repository.UserRepository;
import com.wanari.specification.example.service.errors.ErrorResponse;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Either<ErrorResponse, List<UserDto>> findAll() {
        return Either.right(userMapper.map(userRepository.findAll()));
    }
}
