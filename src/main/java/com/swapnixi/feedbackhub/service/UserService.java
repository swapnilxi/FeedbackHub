package com.swapnixi.feedbackhub.service;
import java.util.*;

import com.swapnixi.feedbackhub.payloads.UserDTO;

public interface UserService {
    //DTO helps us to stop expose of the data
    UserDTO createUser(UserDTO user);
    UserDTO updateUdser(UserDTO user, Integer userId);
    UserDTO getUserbyId(Integer UserId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);
}
