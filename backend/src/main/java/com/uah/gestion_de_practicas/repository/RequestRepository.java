package com.uah.gestion_de_practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uah.gestion_de_practicas.model.Request;
import com.uah.gestion_de_practicas.model.Student;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Request r WHERE r.student.id = :id")
    void deleteByStudentId(@Param("id") Long id);

    @Query("SELECT r FROM Request r WHERE r.student.id = :id")
    List<Request> findAllByStudentId(@Param("id") Long id);

    @Query("SELECT r.student FROM Request r WHERE r.offer.id = :id")
    List<Student> getStudentsByOfferId(@Param("id") Long id);
}
