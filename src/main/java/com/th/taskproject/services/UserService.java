package com.th.taskproject.services;

import com.th.taskproject.dtos.UserCreateDTO;
import com.th.taskproject.dtos.UserGetDTO;
import com.th.taskproject.dtos.UserUpdateDTO;
import com.th.taskproject.entities.User;
import com.th.taskproject.exceptions.ResourceNotFoundException;
import com.th.taskproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserGetDTO convertToDTO(User user) {
        return new UserGetDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public List<UserGetDTO> listAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

    }

    public UserGetDTO findUserById(Long id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        return  convertToDTO(user);
    }

    public UserGetDTO saveUser(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser = userRepository.save(user);
        return  convertToDTO(savedUser);
    }

    public UserGetDTO updateUser(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User savedUser = userRepository.save(user);
        return  convertToDTO(savedUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
