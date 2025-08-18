package com.example.restaurantreview.service;

import com.example.restaurantreview.dto.UserDto;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);
    void updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> getAllUsers();
}
