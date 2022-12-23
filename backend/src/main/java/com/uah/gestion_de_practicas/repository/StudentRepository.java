package com.uah.gestion_de_practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query("SELECT s FROM Student s INNER JOIN Practice p ON s.id = p.student_id INNER JOIN Offer o ON p.offer_id = o.id WHERE o.company_id = :id")
    public List<Student> getStudentsFromCompany(@Param("id") Long id);
    
}
