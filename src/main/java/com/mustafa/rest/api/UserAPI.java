package com.mustafa.rest.api;

import com.mustafa.rest.dto.UserCreateDTO;
import com.mustafa.rest.dto.UserViewDTO;
import com.mustafa.rest.service.UserService;
import com.mustafa.rest.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAPI {

    private UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        UserViewDTO user= userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created"));

    }
}
