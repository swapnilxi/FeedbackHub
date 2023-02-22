package com.swapnixi.feedbackhub.service.implementation ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swapnixi.feedbackhub.entity.User;
import com.swapnixi.feedbackhub.payloads.UserDTO;
import com.swapnixi.feedbackhub.repository.userRepository;
import com.swapnixi.feedbackhub.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    private userRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserDTO updateUdser(UserDTO user, Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUdser'");
    }

    @Override
    public UserDTO getUserbyId(Integer UserId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserbyId'");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public void deleteUser(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    private User DtoToUser(UserDTO userDTO){
        User user= new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        user.setPassword(userDTO.getpassword());
        return user;

    }
    private UserDTO userDTO(User user){
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail()) 
        userDTO.setPassword(user.getPassword());
        userDTO.setAbout(user.getAbout());
    }


    
}
