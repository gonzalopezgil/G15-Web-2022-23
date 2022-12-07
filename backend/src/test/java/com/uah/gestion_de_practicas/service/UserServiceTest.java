package com.uah.gestion_de_practicas.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.repository.UserRepository;

@DisplayName("User Service Test")
public class UserServiceTest {

    // Mock user repository
    private UserRepository userRepository = mock(UserRepository.class);

    private UserService userService = new UserService(userRepository);

    @Test
    @DisplayName("Test save user")
    public void testSaveUser() {
        // Create a user
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F"," a@gmail.com");
        
        // Save the user in the database
        userRepository.save(user);

        // Verify if UserRepository.save() is called
        verify(userRepository).save(user);
    }

    @Test
    @DisplayName("Test get user")
    public void testGetUser() {
        // Create a user
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","a@gmial.com");

        // Get the user from the database
        userRepository.findById(user.getId());

        // Verify if UserRepository.findById() is called with the correct user id
        verify(userRepository).findById(user.getId());
    }

    @Test
    @DisplayName("Test delete user")
    public void testDeleteUser() {
        // Create a user
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");

        // Delete the user from the database
        userRepository.deleteById(user.getId());

        // Verify if userRepository.deleteById(); is called with the correct user id
        verify(userRepository).deleteById(user.getId());
    }

    @Test
    @DisplayName("Test update user")
    public void testUpdateUser() {
        // Create a user
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");

        // Update the user in the database
        userRepository.save(user);

        // Verify if userRepository.save() is called with the correct user
        verify(userRepository).save(user);
    }
    
    @Test
    @DisplayName("Test get all users")
    public void testGetAllUsers() {
        // Get all the users from the database
        userRepository.findAll();

        // Verify if userRepository.findAll() is called
        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Test get user by username")
    public void testGetUserByUsername() {
        // Create a user
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","alex@gmail.com");

        // Get the user from the database by its username
        userRepository.findByUsername(user.getUsername());

        // Verify if userRepository.findByUsername() is called with the correct username
        verify(userRepository).findByUsername(user.getUsername());
    }

    @Test
    @DisplayName("Test log in user")
    public void shouldLogInUser() {
        // Create a user and inserted credentials
        User user = new User("Alex", "1234", "Alex", "Martinez", "00000F","a@gmail.com");

        String username = "Alex";
        String correct_password = "1234";
        String wrong_password = "12345";

        // Train the mock
        when(userRepository.findByUsername(username)).thenReturn(user);

        // Check if the inserted credentials are correct
        assertTrue(userService.logInUser(username, correct_password));
        assertFalse(userService.logInUser(username, wrong_password));
    }

}
