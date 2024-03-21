package com.swapnixi.feedbackhub.service;

import com.swapnixi.feedbackhub.entity.UserDTO;

import java.util.List;


public interface UserService {
    // DTO helps us to stop exposing the data
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Long userId);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Long userId);
}
