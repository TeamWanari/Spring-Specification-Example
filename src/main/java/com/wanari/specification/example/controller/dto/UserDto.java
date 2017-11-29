package com.wanari.specification.example.controller.dto;

import java.util.List;

public class UserDto {
    public Long id;
    public String email;
    public String firstName;
    public String lastName;
    public List<AddressDto> addresses;
}
