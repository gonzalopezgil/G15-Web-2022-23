package com.uah.gestion_de_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.uah.gestion_de_practicas.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    @Query("DELETE FROM Request r WHERE r.student.id = ?1")
    void deleteRequestsByStudentId(Long id);
}
