package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Practice;

@Repository
public interface PracticeRepository extends JpaRepository<Practice,Long> {
    
}
