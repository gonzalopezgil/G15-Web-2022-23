package com.uah.gestion_de_practicas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query("SELECT s FROM Student s INNER JOIN Practice p ON s.id = p.student.id INNER JOIN Offer o ON p.offer.id = o.id WHERE o.company.id = :id")
    public List<Student> getStudentsFromCompany(@Param("id") Long id);

    @Query("SELECT s FROM Student s WHERE s.id NOT IN (SELECT p.student.id FROM Practice p)")
    public List<Student> getAllUnassignedStudents();

    @Query("SELECT s FROM Student s WHERE s.id IN (SELECT p.student.id FROM Practice p WHERE p.offer.id = :offer_id)")
    public List<Student> getElegibleForOffer(@Param("offer_id") Long offer_id);

    @Query("SELECT s.id FROM Student s WHERE s.id IN (SELECT p.student.id FROM Practice p WHERE p.student.id = :id AND p.end_date IS NOT NULL)")
    public Optional<Long> hasActivePractice(@Param("id") Long id);

    @Query("SELECT s FROM Student s INNER JOIN Practice p ON s.id = p.student.id INNER JOIN Offer o ON p.offer.id = o.id INNER JOIN Company c ON o.company.id = c.id INNER JOIN Tutor t ON c.id = t.company.id WHERE t.id = :tutor_id")
    public List<Student> getStudentsFromTutor(@Param("tutor_id") Long tutor_id);
    
}
