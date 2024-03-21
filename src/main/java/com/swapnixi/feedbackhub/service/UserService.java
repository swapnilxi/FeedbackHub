package com.swapnixi.feedbackhub.service;

import java.util.List;

import com.swapnixi.feedbackhub.payloads.UserDTO;

public interface UserService {
    // DTO helps us to stop exposing the data
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId); // Fixed method name to updateUser
    UserDTO getUserById(Integer userId); // Corrected method name to getUserById
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);
}
