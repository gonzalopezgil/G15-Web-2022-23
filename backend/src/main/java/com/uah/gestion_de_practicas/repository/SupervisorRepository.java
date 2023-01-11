package com.uah.gestion_de_practicas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    
    Optional<Supervisor> findSupervisorByUsername(String username);
}
