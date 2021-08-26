package com.mustafa.rest.service;

import com.mustafa.rest.dto.UserCreateDTO;
import com.mustafa.rest.dto.UserUpdateDTO;
import com.mustafa.rest.dto.UserViewDTO;
import com.mustafa.rest.exception.NotFoundException;
import com.mustafa.rest.model.User;
import com.mustafa.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
         User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        User user =userRepository.save(new User(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user=userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found Exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        User updateUser=userRepository.save(user);
        return UserViewDTO.of(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found Exception"));
        userRepository.deleteById(user.getId());

    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
       return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());

    }
}
