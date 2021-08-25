package com.mustafa.rest.service;

import com.mustafa.rest.dto.UserViewDTO;
import com.mustafa.rest.exception.NotFoundException;
import com.mustafa.rest.model.User;
import com.mustafa.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserViewDTO getUserById(Long id) {
         User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found Exception"));
        return UserViewDTO.of(user);
    }
}
