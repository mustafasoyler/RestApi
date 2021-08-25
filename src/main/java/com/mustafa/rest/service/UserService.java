package com.mustafa.rest.service;

import com.mustafa.rest.dto.UserCreateDTO;
import com.mustafa.rest.dto.UserViewDTO;

public interface UserService {

    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);
}
