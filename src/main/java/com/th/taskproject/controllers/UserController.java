package com.th.taskproject.controllers;


import com.th.taskproject.dtos.UserCreateDTO;
import com.th.taskproject.dtos.UserGetDTO;
import com.th.taskproject.dtos.UserUpdateDTO;
import com.th.taskproject.entities.User;
import com.th.taskproject.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetDTO>> getAllUsers(){
        List<UserGetDTO> request = userService.listAllUsers();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDTO> getUserById(@PathVariable Long id){
        UserGetDTO request = userService.findUserById(id);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<UserGetDTO> createUser(@Valid @RequestBody UserCreateDTO dto){

        UserGetDTO user = userService.saveUser(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGetDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto){

        UserGetDTO user = userService.updateUser(id, dto);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
