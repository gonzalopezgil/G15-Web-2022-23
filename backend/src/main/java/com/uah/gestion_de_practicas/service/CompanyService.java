package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.repository.CompanyRepository;

/**
 * Service class for the Company class.
 * Implements the business logic for the Company class.
 */
@Service
public class CompanyService {

    /**
     * Data access repository for the Company class.
     */
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a company in the database.
     */
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    /**
     * Gets a company from the database.
     * @param id Id of the company to be retrieved.
     */
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a company from the database.
     * @param id Id of the company to be deleted.
     */
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    /**
     * Gets all the companies from the database.
     * @return A list with all the companies.
     */
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
}
