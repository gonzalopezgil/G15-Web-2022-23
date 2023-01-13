package com.uah.gestion_de_practicas.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.User;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIT {
    
    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(5L);
        list.add(2L);


        List<Practice> lista = practiceRepository.findAllById(list);

        for (Practice practice : lista) {
            System.out.println(practice.getId());
        }

    }

    @Test
    public void getUser(){
        // Set up test+
        String unique_value = String.valueOf(Math.random());
        User user = new User("Alex2"+unique_value,"1234","Alex","Gonzalez","disa"+unique_value,"alexgonzalez@gmail.com"+unique_value);
        User saved_user = userRepository.save(user);
        Long user_id = saved_user.getId();

        // Verify that the user retrieved is the same as the previously saved user
        assertTrue(saved_user.equals(userRepository.findById(user_id).get()));

        userRepository.deleteById(saved_user.getId());
    }

    @Test
    public void deleteUser(){
        String unique_value = String.valueOf(Math.random());
        User user = new User("Alex3"+unique_value,"1234","Alex","Gonzalez",unique_value,"alexgonzalez@gmail.com"+unique_value);
        User saved_user = userRepository.save(user);

        // Delete the user
        userRepository.deleteById(saved_user.getId());

        // Verify that the user has been deleted
        assertEquals(null, userRepository.findById(saved_user.getId()).orElse(null));
    }
}
