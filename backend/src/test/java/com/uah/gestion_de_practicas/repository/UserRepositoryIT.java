package com.uah.gestion_de_practicas.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.uah.gestion_de_practicas.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIT {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        // Set up test
        User user = new User("Alex","1234","Alex","Gonzalez","12345678A","alexgonzalez@gmail.com");
        User saved_user = userRepository.save(user);
        user.setId(saved_user.getId());

        // Verify that the user saved is the same as the input user
        assertEquals(user, saved_user);

    }

    @Test
    public void getUser(){
        // Set up test
        User user = new User("Alex","1234","Alex","Gonzalez","12345678A","alexgonzalez@gmail.com");
        User saved_user = userRepository.save(user);
        Long user_id = saved_user.getId();

        // Verify that the user retrieved is the same as the previously saved user
        assertTrue(saved_user.equals(userRepository.findById(user_id).get()));
    }

    @Test
    public void deleteUser(){
        // Set up test
        User user = new User ("Alex","1234","Alex","Gonzalez","12345678A","alex@gmail.com");
        User saved_user = userRepository.save(user);

        // Delete the user
        userRepository.deleteById(saved_user.getId());

        // Verify that the user has been deleted
        assertEquals(null, userRepository.findById(saved_user.getId()).orElse(null));
    }

    @Test
    public void updateUser(){
        // Set up test
        User user = new User("Alex","1234","Alex","Gonzalez","12345678A","a@gmail.com");
        user = userRepository.save(user);

        // Update the user
        User updated_user = new User("Alex","1234","Alex","Gonzalez","12345678A","b@gmail.com");
        updated_user.setId(user.getId());
        updated_user = userRepository.save(updated_user);

        // Verify that the user has been updated that the updated user is different than the originally saved
        assertNotEquals(user, updated_user);
    }
}
