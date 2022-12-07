package com.uah.gestion_de_practicas.repository;

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
        User user = new User("Alex","1234","Alex","Gonzalez","12345678A","alexgonzalez@gmail.com");
        userRepository.save(user);
    }
}
