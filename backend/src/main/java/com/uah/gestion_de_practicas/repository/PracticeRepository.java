package com.uah.gestion_de_practicas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;

@Repository
public interface PracticeRepository extends JpaRepository<Practice,Long> {
    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO(p.id, p.student.id, p.offer.id, p.mark, p.report, p.start_date, p.end_date) FROM Practice p")
    List<SimplePracticeDAO> findAllPractices();

    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO(p.id, p.student.id, p.offer.id, p.mark, p.report, p.start_date, p.end_date) FROM Practice p WHERE p.id = ?1")
    Optional<SimplePracticeDAO> findPracticeById(Long id);

    @Query("SELECT p FROM Practice p INNER JOIN Offer o ON p.offer.id = o.id WHERE o.company.id = ?1")
    List<Practice> getPracticeHistory(Long id);

    @Query("SELECT new com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO(p.id, p.student.id, p.offer.id, p.mark, p.report, p.start_date, p.end_date) FROM Practice p WHERE p.end_date IS NOT NULL")
    List<SimplePracticeDAO> getCompletedPractices();
}
