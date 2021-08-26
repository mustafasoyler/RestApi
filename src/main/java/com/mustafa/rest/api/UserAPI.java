package com.mustafa.rest.api;

import com.mustafa.rest.dto.UserCreateDTO;
import com.mustafa.rest.dto.UserUpdateDTO;
import com.mustafa.rest.dto.UserViewDTO;
import com.mustafa.rest.service.UserService;
import com.mustafa.rest.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAPI {

    private UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        List<UserViewDTO> users= userService.getUsers();
         return ResponseEntity.ok(users);
    }

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        UserViewDTO user= userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created"));

    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        UserViewDTO user= userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User deleted"));

    }
    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
       List<UserViewDTO> users=userService.slice(pageable);
        return ResponseEntity.ok(users);
    }
}
