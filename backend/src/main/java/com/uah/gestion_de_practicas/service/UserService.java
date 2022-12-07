package com.uah.gestion_de_practicas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.repository.UserRepository;

import java.util.List;

/**
 * Service class for the User class.
 * Implements the business logic for the User class.
 */
@Service
public class UserService {

    /**
     * Data access repository for the User class.
     */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // ------------------- CRUD OPERATIONS ------------------- //
    /**
     * Saves a user in the database.
     * @param user User to be saved.
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Gets a user from the database.
     * @param id Id of the user to be retrieved.
     */
    public void getUser(Long id) {
        userRepository.findById(id);
    }

    /**
     * Deletes a user from the database.
     * @param id Id of the user to be deleted.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Updates a user in the database.
     * @param user User to be updated.
     */
    public void updateUser(User user) {
        userRepository.save(user);
    }

    /**
     * Gets all the users from the database.
     * @return A list with all the users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ------------------- SPECIFIC OPERATIONS ------------------- //

    /**
     * Gets a user from the database by its username.
     * @param username Username of the user to be retrieved.
     * @return The user with the given username.
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Gets a user from the database by its nif.
     * @param nif Nif of the user to be retrieved.
     * @return The user with the given nif.
     */
    public User getUserByNif(String nif) {
        return userRepository.findById(nif);
    }

    /**
     * @param username Username inserted by the user
     * @param password Password inserted by the user
     * @return True if the credentials correspond to a valid user.
     */
    public boolean logInUser(String username, String password) {
        User stored_user = userRepository.findByUsername(username);
        return stored_user != null && stored_user.getPassword().equals(password);
    }
    
}
