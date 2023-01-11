package com.uah.gestion_de_practicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.AuthDTO;
import com.uah.gestion_de_practicas.controller.dto.UserDTO;
import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.security.jwt.JwtTokenUtil;
import com.uah.gestion_de_practicas.security.payload.JwtResponse;
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

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtTokenUtil;

    public UserController(UserService userService, AuthenticationManager authManager, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    /**
     * Get all the users
     * Only the supervisor can access this endpoint
     * @return ResponseEntity<List<UserDTO>> list of all the users
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")   
    @GetMapping("")
    @ApiOperation("Get all the users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<User> users = userService.getAllUsers(username);
        if (users == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Convert the list of users to a list of UserDTOs
        List<UserDTO> userDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    /**
     * Get a user by its id
     * Only the user itself, the tutor of the user or the supervisor can access this endpoint
     * @param id Long id of the user
     * @return ResponseEntity<UserDTO> the user
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a user by its id")
    public ResponseEntity<UserDTO> getUserById(@ApiParam("The id of the user") @PathVariable(name = "id") Long id) {

        // Security check
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userService.isAuthorized(username, id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        User user = userService.getUser(id);
        if (user != null)
            return ResponseEntity.ok(new UserDTO(user));
        else
            return ResponseEntity.notFound().build();
    }

    /**
     * Logs in a user by its username and password
     * @param authDTO AuthDTO containing the username and password of the user
     * @return ResponseEntity<JwtResponse> the JWT token if the user was logged in, Unauthorized otherwise
     */
    @PostMapping("/login")
    @ApiOperation("Logs in a user by its username and password")
    public ResponseEntity<JwtResponse> logInUser(@ApiParam("JSON containing the username and password of the user") @RequestBody AuthDTO authDTO) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDTO.getUsername(),
                        authDTO.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }    
}
