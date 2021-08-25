package com.mustafa.rest.service;

import com.mustafa.rest.dto.UserViewDTO;

public interface UserService {

    UserViewDTO getUserById(Long id);
}
