// package com.uah.gestion_de_practicas.controller;

// import static org.junit.Assert.assertNotEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.Test;
// import org.junit.jupiter.api.DisplayName;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;

// import com.uah.gestion_de_practicas.controller.dto.UserDTO;
// import com.uah.gestion_de_practicas.model.User;
// import com.uah.gestion_de_practicas.security.jwt.JwtTokenUtil;
// import com.uah.gestion_de_practicas.service.UserService;

// @DisplayName("User Controller Unit Tests")
// public class UserControllerTest {
    
//     private UserService userService = mock(UserService.class);

//     @Autowired
//     private AuthenticationManager authManager;

//     @Autowired
//     private JwtTokenUtil jwtTokenUtil;

//     private UserController userController = new UserController(userService, authManager, jwtTokenUtil);

//     @Test
//     public void getAllUsers() {
//         // Set up test
//         List<User> users = new ArrayList<>();
//         users.add(new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com"));

//         List<UserDTO> userDTOs_expected = new ArrayList<>();
//         userDTOs_expected.add(new UserDTO(users.get(0)));

//         // Mock the service
//         when(userService.getAllUsers()).thenReturn(users);

//         // Run the test
//         List<UserDTO> userDTOs = userController.getAllUsers().getBody();

//         // Assert the result
//         assertEquals(userDTOs_expected, userDTOs);
//     }

//     @Test
//     public void getUserById(){
//         // Set up test
//         User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");
//         User other_user = new User("Pepe", "1234", "Pepe", "Martinez", "00000F","pepe@gmail.com");

//         UserDTO userDTO_expected = new UserDTO(user);

//         // Mock the service
//         when(userService.getUser(1L)).thenReturn(user);
//         when(userService.getUser(2L)).thenReturn(other_user);

//         // Run the test
//         UserDTO userDTO = userController.getUserById(1L).getBody();
//         UserDTO other_userDTO = userController.getUserById(2L).getBody();

//         // Assert the result
//         assertEquals(userDTO_expected, userDTO);
//         assertNotEquals(userDTO_expected, other_userDTO);
//     }

//     @Test
//     public void registerUser(){
//         // Set up test
//         User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");

//         UserDTO userDTO_expected = new UserDTO(user);

//         // Mock the service
//         when(userService.saveUser(user)).thenReturn(user);

//         // Run the test
//         UserDTO userDTO = userController.registerUser(user).getBody();

//         // Assert the result
//         assertEquals(userDTO_expected, userDTO);
//     }

//     @Test
//     public void updateUser(){
//         // Set up test
//         User original_user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");
//         original_user.setId(1L);

//         UserDTO userDTO_expected = new UserDTO(original_user);

//         // Mock the service
//         when(userService.getUser(original_user.getId())).thenReturn(original_user);
//         when(userService.getUser(100L)).thenReturn(null);
//         when(userService.saveUser(original_user)).thenReturn(original_user);

//         // Run the test for existent and non-existent user
//         UserDTO userDTO = userController.updateUser(original_user.getId(), original_user).getBody();
//         UserDTO non_existent_userDTO = userController.updateUser(100L, original_user).getBody();

//         // Assert the result
//         assertEquals(userDTO_expected, userDTO);
//         assertNotEquals(userDTO_expected, non_existent_userDTO);
//     }

//     @Test
//     public void deleteUser(){
//         // Set up test
//         User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");
//         user.setId(1L);

//         // Delete user
//         userController.deleteUser(user.getId());

//         // Assert the result
//         assertEquals(200, userController.deleteUser(user.getId()).getStatusCodeValue());
//     }
// }
