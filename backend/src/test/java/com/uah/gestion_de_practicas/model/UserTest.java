package test.java.com.uah.gestion_de_practicas.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

public class UserTest{
    private User user;
    
    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public `should get id`(){
        // Given
        Long id = 1L;
        user.setId(id);
        
        // When
        Long result = user.getId();
        
        // Then
        Assertions.assertEquals(id, result);
    }

    @Test
    public `should get username`(){
        // Given
        String username = "daniel21";
        user.setUsername(username);
        
        // When
        String result = user.getUsername();
        
        // Then
        Assertions.assertEquals(username, result);
    }

    @Test
    public `should get password`(){
        // Given
        String password = "markevans21";
        user.setPassword(password);
        
        // When
        String result = user.getPassword();
        
        // Then
        Assertions.assertEquals(password, result);
    }

    @Test
    public `should get first_name`(){
        // Given
        String first_name = "Daniel";
        user.setFirst_name(first_name);
        
        // When
        String result = user.getFirst_name();
        
        // Then
        Assertions.assertEquals(first_name, result);
    }

    @Test
    public `should get last_name`(){
        // Given
        String last_name = "Martinez";
        user.setLast_name(last_name);
        
        // When
        String result = user.getLast_name();
        
        // Then
        Assertions.assertEquals(last_name, result);
    }

    @Test
    public `should get nif`(){
        // Given
        String nif = "01234567N";
        user.setNif(nif);
        
        // When
        String result = user.getNif();
        
        // Then
        Assertions.assertEquals(nif, result);
    }

    @Test
    public `should get email`(){
        // Given
        String email = "daniel21@edu.uah.es";
        user.setEmail(email);
        
        // When
        String result = user.getEmail();
        
        // Then
        Assertions.assertEquals(email, result);
    }
}