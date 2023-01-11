package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t")
    List<TutorDAO> getAllTutors();
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t WHERE t.id = ?1")
    Optional<TutorDAO> getTutorById(Long id);

    Optional<Tutor> findTutorByUsername(String username);

    @Query("SELECT DISTINCT(t.username) FROM Tutor t INNER JOIN Company c ON t.company.id = c.id INNER JOIN Offer o ON c.id = o.company.id INNER JOIN Practice p ON o.id = p.offer.id WHERE p.id IN (:practices_ids)")
    List<String> getTutorOfPractices(@Param("practices_ids") List<Long> practices_ids);
}
