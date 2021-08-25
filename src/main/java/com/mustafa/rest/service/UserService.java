package com.mustafa.rest.service;

import com.mustafa.rest.dto.UserCreateDTO;
import com.mustafa.rest.dto.UserUpdateDTO;
import com.mustafa.rest.dto.UserViewDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getUsers();

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);
}
