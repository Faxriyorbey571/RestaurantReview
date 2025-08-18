package com.example.restaurantreview.service.impl;

import com.example.restaurantreview.dto.UserDto;
import com.example.restaurantreview.repository.UserRepository;
import com.example.restaurantreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        userRepository.createUser(userDto);
    }

    public void updateUser(Long id, UserDto userDto) {
        userRepository.updateUser(id, userDto);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
