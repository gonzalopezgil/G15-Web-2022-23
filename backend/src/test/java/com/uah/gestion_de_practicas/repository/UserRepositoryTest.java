package com.uah.gestion_de_practicas.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import com.uah.gestion_de_practicas.model.User;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("`findAll` should return all users")
    public void testFindAll() {
        userRepository.findAll();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    @DisplayName("`findById` should return the user with the specified id")
    public void testFindById() {
        userRepository.findById(1L);
        Mockito.verify(userRepository).findById(1L);
    }

    @Test
    @DisplayName("`save` should save a user")
    public void testSave() {
        User test_user = new User();
        userRepository.save(test_user);
        Mockito.verify(userRepository).save(test_user);
    }

    @Test
    @DisplayName("`delete` should delete a user")
    public void testDelete() {
        User test_user = new User();
        userRepository.delete(test_user);
        Mockito.verify(userRepository).delete(test_user);
    }

    @Test
    @DisplayName("`deleteById` should delete a user with the specified id")
    public void testDeleteById() {
        userRepository.deleteById(1L);
        Mockito.verify(userRepository).deleteById(1L);
    }
}