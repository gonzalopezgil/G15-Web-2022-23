package com.uah.gestion_de_practicas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.AuthDTO;
import com.uah.gestion_de_practicas.controller.dto.UserDTO;
import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Rest Controller for the User endpoint
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Get all the users
     * @return ResponseEntity<List<UserDTO>> list of all the users
     */
    @GetMapping("")
    @ApiOperation("Get all the users")
    public ResponseEntity <List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        // Convert the list of users to a list of UserDTOs
        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    /**
     * Get a user by its id
     * @param id Long id of the user
     * @return ResponseEntity<UserDTO> the user
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a user by its id")
    public ResponseEntity<UserDTO> getUserById(@ApiParam ("The id of the user") @PathVariable(name = "id") Long id) {
        User user = userService.getUser(id);
        if (user != null)
            return ResponseEntity.ok(new UserDTO(user));
        else
            return ResponseEntity.notFound().build();
    }

    /**
     * Logs in a user by its username and password
     * @param username String username
     * @param password String encoded password
     * @return ResponseEntity<Boolean> true if the user was logged in, false otherwise
     */
    @PostMapping("/login")
    @ApiOperation("Logs in a user by its username and password")
    public ResponseEntity<Boolean> logInUser(@ApiParam("JSON containing the username and password of the user") @RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(userService.logInUser(authDTO.getUsername(), authDTO.getPassword()));
    }    
}
