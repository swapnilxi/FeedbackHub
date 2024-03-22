package com.swapnixi.feedbackhub.service;

import com.swapnixi.feedbackhub.entity.User;
import com.swapnixi.feedbackhub.entity.UserDTO;

import java.util.List;


public interface UserService {
    // DTO helps us to stop exposing the data
    User createUser(User user);
    UserDTO updateUser(UserDTO user, Long userId);
    UserDTO getUserById(Long userId);
    List<User> getAllUsers();
    void deleteUser(Long userId);

    List<User> getUsersWithNameContainingNewKeyword();
}
