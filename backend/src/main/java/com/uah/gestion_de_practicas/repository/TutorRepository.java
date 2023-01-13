package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;
import com.uah.gestion_de_practicas.repository.dao.TutorPerPracticeDAO;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t")
    List<TutorDAO> getAllTutors();
    
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorDAO(t.id, t.company.id, t.admission_date, t.removal_date) FROM Tutor t WHERE t.id = ?1")
    Optional<TutorDAO> getTutorById(Long id);

    Optional<Tutor> findTutorByUsername(String username);

    @Query("SELECT DISTINCT(t.username) FROM Tutor t INNER JOIN Company c ON t.company.id = c.id INNER JOIN Offer o ON c.id = o.company.id INNER JOIN Practice p ON o.id = p.offer.id WHERE p.id IN (:practices_ids)")
    List<String> getTutorOfPractices(@Param("practices_ids") List<Long> practices_ids);

    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.TutorPerPracticeDAO(t.first_name, t.last_name, t.id) FROM Tutor t WHERE t.company.id = ?1 AND t.removal_date IS NULL")
    TutorPerPracticeDAO getTutorByCompany(Long company_id);

    @Query("SELECT p FROM Practice p INNER JOIN Offer o on p.offer.id = o.id INNER JOIN Company c on o.company.id = c.id INNER JOIN Tutor t on c.id = t.company.id WHERE t.id = ?1")
    List<Practice> getPracticesByTutor(Long id);

    @Query("SELECT o FROM Offer o INNER JOIN Company c on o.company.id = c.id INNER JOIN Tutor t on c.id = t.company.id WHERE t.id = ?1")
    List<Offer> getOffersByTutor(Long id);
}
