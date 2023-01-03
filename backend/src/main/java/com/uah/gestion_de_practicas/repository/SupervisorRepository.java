package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uah.gestion_de_practicas.model.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    
    
}
