package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t")
    List<TutorDAO> getAllTutors();
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t WHERE t.id = ?1")
    Optional<TutorDAO> getTutorById(Long id);

    Optional<Tutor> findTutorByUsername(String username);
}
