package com.uah.gestion_de_practicas.repository;

import org.springframework.stereotype.Repository;
import com.uah.gestion_de_practicas.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findById(String nif);
    
}
