package com.gk.usermanagement.service;

import com.gk.usermanagement.model.CreateUserRequestDTO;
import com.gk.usermanagement.model.CreateUserResponseDTO;


public interface UserService {
    /*CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);
    public CreateUserResponseDTO getUser(Long id);*/
    CreateUserResponseDTO createUserWithProfile(CreateUserRequestDTO requestDTO);

    public CreateUserResponseDTO getUserWithProfile(Long id);
}
