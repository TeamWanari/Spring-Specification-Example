package com.wanari.specification.example.service;

import com.wanari.specification.example.controller.dto.UserDto;
import com.wanari.specification.example.controller.dto.UserListRequest;
import com.wanari.specification.example.controller.mapper.UserMapper;
import com.wanari.specification.example.controller.specification.UserListSpecification;
import com.wanari.specification.example.domain.User;
import com.wanari.specification.example.repository.UserRepository;
import com.wanari.specification.example.service.errors.ErrorResponse;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserListSpecification userListSpecification;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserListSpecification userListSpecification) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userListSpecification = userListSpecification;
    }

    public Either<ErrorResponse, Page<UserDto>> findAll(UserListRequest request, Pageable pageable) {
        Page<User> userPage = userRepository.findAll(userListSpecification.getFilter(request), pageable);
        return Either.right(userPage.map(userMapper::map));
    }
}
