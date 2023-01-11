package com.uah.gestion_de_practicas.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;


@DisplayName("UserTest")
public class UserTest{
    private User user;
    
    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("`getId` should return the id of the user.")
    public void TestGetId(){
        // Given
        Long id = 1L;
        user.setId(id);
        
        // When
        Long result = user.getId();
        
        // Then
        Assertions.assertEquals(id, result);
    }

    @Test
    @DisplayName("`getUsername` should return the username of the user.")
    public void TestGetUsername(){
        // Given
        String username = "daniel21";
        user.setUsername(username);
        
        // When
        String result = user.getUsername();
        
        // Then
        Assertions.assertEquals(username, result);
    }

    @Test
    @DisplayName("`getPassword` should return the password of the user.")
    public void TestGetPassword(){
        // Given
        String password = "markevans21";
        user.setPassword(password);
        
        // When
        String result = user.getPassword();
        
        // Then
        Assertions.assertEquals(password, result);
    }

    @Test
    @DisplayName("`getFirst_name` should return the first name of the user.")
    public void TestGetFirstName(){
        // Given
        String first_name = "Daniel";
        user.setFirstName(first_name);
        
        // When
        String result = user.getFirstName();
        
        // Then
        Assertions.assertEquals(first_name, result);
    }

    @Test
    @DisplayName("`getLast_name` should return the last name of the user.")
    public void TestGetLastName(){
        // Given
        String last_name = "Martinez";
        user.setLastName(last_name);
        
        // When
        String result = user.getLastName();
        
        // Then
        Assertions.assertEquals(last_name, result);
    }

    @Test
    @DisplayName("`getNif` should return the nif of the user.")
    public void TestGetNif(){
        // Given
        String nif = "12345678A";
        user.setNif(nif);

        // When
        String result = user.getNif();

        // Then
        Assertions.assertEquals(nif, result);
    }

    @Test
    @DisplayName("`getEmail` should return the email of the user.")
    public void TestGetEmail(){
        // Given
        String email = "daniel21@edu.uah.es";
        user.setEmail(email);
        
        // When
        String result = user.getEmail();
        
        // Then
        Assertions.assertEquals(email, result);
    }
}