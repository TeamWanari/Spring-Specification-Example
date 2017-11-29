package com.wanari.specification.example.controller.mapper;

import com.wanari.specification.example.controller.dto.UserDto;
import com.wanari.specification.example.domain.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(User user);

    List<UserDto> map(List<User> users);
}
