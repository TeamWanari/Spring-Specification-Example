package com.wanari.specification.example.controller;

import com.wanari.specification.example.controller.dto.UserListRequest;
import com.wanari.specification.example.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
        value = "",
        method = RequestMethod.GET)
    public ResponseEntity getAllUser(UserListRequest request, Pageable pageable) {
        return userService.findAll(request, pageable).fold(
            this::errorToResponse,
            this::toResponse
        );
    }
}
