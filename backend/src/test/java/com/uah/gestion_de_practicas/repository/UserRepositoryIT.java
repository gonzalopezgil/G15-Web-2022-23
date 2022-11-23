package com.uah.gestion_de_practicas.repository;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uah.gestion_de_practicas.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryIT {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("`save` should save a user")
    public void save() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@gmail.com");
        user.setPassword("password");
        user.setUsername("johnnyD");
        user.setNif("12345678A");

       userRepository.save(user);

       // Assert that the user was saved
       userRepository.findById(user.getId()).isPresent();
    }

    @Test
    @DisplayName("`delete` should delete a user")
    public void delete() {
        // Initial state
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@gmail.com");
        user.setPassword("password");
        user.setUsername("jonny");
        user.setNif("12345679A");

        userRepository.save(user);

        // Delete user
        userRepository.delete(user);

        // Assert that the user was deleteed
        userRepository.findById(user.getId()).isEmpty();
    }
}
