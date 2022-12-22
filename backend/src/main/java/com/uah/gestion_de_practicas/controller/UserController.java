package com.uah.gestion_de_practicas.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.UserDTO;
import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Rest Controller for the User endpoint
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        // Convert the list of users to a list of UserDTOs
        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name="id") Long id) {
        User user = userService.getUser(id);
        if (user != null)
            return ResponseEntity.ok(new UserDTO(user));
        else
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
        User registered_user = userService.saveUser(user);
        return ResponseEntity.ok(new UserDTO(registered_user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable (name="id") Long id, @RequestBody User user) {
        if (userService.getUser(id) != null ){
            user.setId(id);
            User updated_user = userService.saveUser(user);
            return ResponseEntity.ok(new UserDTO(updated_user));
        }else{
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable (name="id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> logInUser(String username, String password) {
        return ResponseEntity.ok(userService.logInUser(username, password));
    }    
}
