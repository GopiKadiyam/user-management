package com.gk.usermanagement.controller;

import com.gk.usermanagement.model.CreateUserRequestDTO;
import com.gk.usermanagement.model.CreateUserResponseDTO;
import com.gk.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public CreateUserResponseDTO createUser(@RequestBody CreateUserRequestDTO requestDTO){
        return userService.createUserWithProfile(requestDTO);
    }
    @GetMapping("/{id}")
    public CreateUserResponseDTO getUser(@PathVariable("id") Long id){
        return userService.getUserWithProfile(id);
    }
}
