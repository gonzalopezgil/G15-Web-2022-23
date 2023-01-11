package com.uah.gestion_de_practicas.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.model.User;
import com.uah.gestion_de_practicas.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for the User class.
 * Implements the business logic for the User class.
 */
@Service
public class UserService implements UserDetailsService {

    /**
     * Data access repository for the User class.
     */
    private final UserRepository userRepository;

    /**
     * Service class for the Tutor class.
     */
    private final TutorService tutorService;

    /**
     * Service class for the Student class.
     */
    private final StudentService studentService;
    
    /** 
     * Service class for the Supervisor class.
     */
    private final SupervisorService supervisorService;

    public UserService(UserRepository userRepository, TutorService tutorService, StudentService studentService, SupervisorService supervisorService) {
        this.userRepository = userRepository;
        this.tutorService = tutorService;
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }


    // ------------------- CRUD OPERATIONS ------------------- //
    /**
     * Saves a user in the database.
     * @param user User to be saved.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Gets a user from the database.
     * @param id Id of the user to be retrieved.
     */
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a user from the database.
     * @param id Id of the user to be deleted.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
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
        return userRepository.findByUsername(username).orElse(null);
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
     * Gets the role of a user from the database.
     * @param id Id of the user to be retrieved.
     * @return The role of the user
     */
    public SimpleGrantedAuthority getRole(Long id) {
        User user = getUser(id);
        if (user == null) {
            return new SimpleGrantedAuthority("NONE");
        } else if (tutorService.getTutor(id) != null) {
            return new SimpleGrantedAuthority("ROLE_TUTOR");
        } else if (studentService.getStudent(id) != null) {
            return new SimpleGrantedAuthority("ROLE_STUDENT");
        } else if (supervisorService.getSupervisor(id) != null) {
            return new SimpleGrantedAuthority("ROLE_SUPERVISOR");
        } else {
            return new SimpleGrantedAuthority("NONE");
        }
    }

    /** 
     * Checks if a user is authorized to access the information.
     * The user itself, the tutor of the student or the supervisor are authorized.
     * @param username Username of the real user trying to access the information.
     * @param id Id of the user whose information is being accessed.
     * @return True if the user is authorized, false otherwise.
     */
    public boolean isAuthorized(String username, Long id) {
        User user = getUserByUsername(username);
        if (user == null) return false;
        if (user.getId().equals(id)) return true;

        String role = getRole(user.getId()).getAuthority();

        if (role.equals("ROLE_SUPERVISOR")) return true;
        if (role.equals("ROLE_TUTOR")) {
            List<Student> students = studentService.getStudentsFromTutor(user.getId());
            List<Long> ids = students.stream().filter(student -> student.getId()==id).map(student -> student.getId()).collect(Collectors.toList());
            return (ids.size() > 0);
        }
        return false;
    }

    // ------------------- OVERRIDDEN METHODS ------------------- //

    /**
     * Loads a user from the database by its username.
     * @param username Username inserted by the user
     * @param password Password inserted by the user
     * @return UserDetails object with the user's data
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(getRole(user.getId()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


    
}
