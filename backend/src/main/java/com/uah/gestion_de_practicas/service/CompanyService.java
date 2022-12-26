package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.controller.dto.StudentDTO;
import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.CompanyRepository;
import com.uah.gestion_de_practicas.repository.dao.CompanyStudentsDAO;

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

    /**
     * Service class for the Student class.
     */
    private final StudentService studentService;

    /**
     * Service class for the Practice class.
     */
    private final PracticeService practiceService;

    public CompanyService(CompanyRepository companyRepository, StudentService studentService, PracticeService practiceService) {
        this.companyRepository = companyRepository;
        this.studentService = studentService;
        this.practiceService = practiceService;
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
     * @param id, Id of the company to be retrieved.
     */
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a company from the database.
     * @param id, Id of the company to be deleted.
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

    /**
     * Gets all the companies from the database with their students.
     * @return A list with all the companies and their students.
     */
    public List<CompanyStudentsDAO> getAllCompaniesWithStudents() {
        return companyRepository.getAllCompaniesWithStudents();
    }

    /**
     * Gets all the students from a company.
     * @param id, Id of the company.
     * @return A list with all the students from the company.
     */
    public List<StudentDTO> getStudentsInCompany(Long id) {
        return studentService.getStudentsFromCompany(id);
    }

    /**
     * Gets the history of practices of a student.
     * Those practices that have been done or are being done in the company.
     * @param id, Id of the company.
     * @return A list with the history of practices of the company.
     */
    public List<Practice> getPracticeHistory(Long id) {
        return practiceService.getPracticeHistory(id);
    }

    /**
     * Publishes the reports of the practices of a company.
     * @param practices, List of practices to be published.
     * @return A list with the practices updated of the company.
     */
    public List<Practice> publishReports(List<Practice> practices) {
        return practiceService.saveAllPractices(practices);
    }


    
}
