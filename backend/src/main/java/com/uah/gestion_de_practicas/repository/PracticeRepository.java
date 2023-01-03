package com.uah.gestion_de_practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Practice;

@Repository
public interface PracticeRepository extends JpaRepository<Practice,Long> {

    @Query("SELECT p FROM Practice p INNER JOIN Offer o ON p.offer_id = o.id WHERE o.company_id = ?1")
    List<Practice> getPracticeHistory(Long id);

    @Query("SELECT p FROM Practice p WHERE p.end_date IS NOT NULL ")
    List<Practice> getCompletedPractices();
}
