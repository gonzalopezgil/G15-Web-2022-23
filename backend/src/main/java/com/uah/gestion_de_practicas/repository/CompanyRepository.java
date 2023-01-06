package com.uah.gestion_de_practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.repository.dao.CompanyStudentsDAO;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT new com.uah.gestion_de_practicas.controller.dto.CompanyStudentsDTO(c.id, c.name, c.description, COUNT(c)) FROM Company c INNER JOIN Offer o ON c.id = o.company_id INNER JOIN Practice p ON o.id = p.offer_id WHERE p.end_date IS NULL GROUP BY c.id, c.name, c.description")
    public List<CompanyStudentsDAO> getAllCompaniesWithStudents();
    
}
