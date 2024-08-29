package com.swapnixi.feedbackhub.service.implementation;

import java.util.List;

import com.swapnixi.feedbackhub.entity.UserDTO;
import com.swapnixi.feedbackhub.entity.User;
import com.swapnixi.feedbackhub.repository.UserRepository;
import com.swapnixi.feedbackhub.exception.ResourceNotFoundException;
import com.swapnixi.feedbackhub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
//        User user = DtoToUser(user);
        User savedUser = userRepository.save(user);
//        return userToDTO(savedUser);
        return  savedUser;
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getAbout() != null) {
            user.setAbout(userDto.getAbout());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }

        User updatedUser = userRepository.save(user);
        return userToDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userToDTO(user);
    }

    @Override
    public List<User> getAllUsers() {
        // Implement your logic to fetch all users from the repository
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        // Implementation for deleting a user by ID
        // This method should delete the user with the given ID from the repository
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public List<User> getUsersWithNameContainingNewKeyword() {
        return  userRepository.nameHasNewKeyword();
    }

    private UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAbout(user.getAbout());
        return userDTO;
    }
}
