package com.uah.gestion_de_practicas.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.uah.gestion_de_practicas.controller.dto.UserDTO;
import com.uah.gestion_de_practicas.model.User;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerMVC {
    @Autowired
    private MockMvc mockMvc;
    

    public UserControllerMVC() {
    }

    @Test
    public void registerUser() {
        // Set up test
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");
        UserDTO userDTO_expected = new UserDTO(user);

        // Run the test
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userDTO_expected)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(body().equals(userDTO_expected));
    }

    @Test
    public void getAllUsers() {
        // Set up test
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com"));

        List<UserDTO> userDTOs_expected = new ArrayList<>();
        userDTOs_expected.add(userController.registerUser(users.get(0)).getBody());

        // Run the test
        List<UserDTO> userDTOs = userController.getAllUsers().getBody();

        // Assert the result
        assertEquals(users, userDTOs);
    }

    @Test
    public void getUserById(){
        // Set up test
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");
        
        UserDTO userDTO_expected = userController.registerUser(user).getBody();
    

        // Run the test
        UserDTO userDTO = userController.getUserById(userDTO_expected.getId()).getBody();

        // Assert the result
        assertEquals(userDTO_expected, userDTO);
    }

    @Test
    public void updateUser(){
        // Set up test
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","a@gmail.com");

        UserDTO userDTO_expected = userController.registerUser(user).getBody();
        userDTO_expected.setEmail("b@gmail.com");

        // Run the test
        User updated_user = new User("Alex", "1234", "Alex", "Martinez", "00000F","b@gmail.com");
        UserDTO userDTO = userController.updateUser(userDTO_expected.getId(), updated_user).getBody();

        // Assert the result
        assertEquals(userDTO_expected, userDTO);
    }   
}
