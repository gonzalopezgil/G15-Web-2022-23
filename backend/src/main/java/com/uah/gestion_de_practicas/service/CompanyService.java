package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Student;
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

    /** 
     * Service class for the Tutor class.
     */
    private final TutorService tutorService;

    /**
     * Service class for the Supervisor class
     */
    private final SupervisorService supervisorService;

    public CompanyService(CompanyRepository companyRepository, StudentService studentService, PracticeService practiceService, TutorService tutorService, SupervisorService supervisorService) {
        this.companyRepository = companyRepository;
        this.studentService = studentService;
        this.practiceService = practiceService;
        this.tutorService = tutorService;
        this.supervisorService = supervisorService;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a company in the database.
     * @param company, Company to be saved.
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

    // ------------------- CUSTOM OPERATIONS ------------------- //

    /** 
     * A tutor saves a company in the database.
     * @param company, Company to be saved.
     * @param tutor_username, Username of the tutor that saves the company.
     */
    @Transactional
    public Company saveCompanyByTutor(Company company, String tutor_username) {
        if (!tutorService.isAuthorized(tutor_username)) {
            return null;
        }

        Company saved_company = companyRepository.save(company);
        if (tutorService.updateTutorCompany(tutor_username, saved_company) == null) {
            return null;
        }

        return saved_company;
    }

    /** 
     * Update a company by a tutor.
     * @param company, Company to be updated.
     * @param tutor_username, Username of the tutor that updates the company.
     */
    public Company updateCompanyByTutor(Company company, String tutor_username) {
        if (!tutorService.isAuthorized(tutor_username, company.getId())) {
            return null;
        }

        return companyRepository.save(company);
    }

    /**
     * Gets all the companies from the database with their students.
     * Only the supervisor can obtain this information.
     * @param supervisor_username, Username of the supervisor that wants to obtain the information.
     * @return A list with all the companies and their students.
     */
    public List<CompanyStudentsDAO> getAllCompaniesWithStudents(String supervisor_username) {
        if (!supervisorService.isAuthorized(supervisor_username)) {
            return null;
        }
        return companyRepository.getAllCompaniesWithStudents();
    }

    /**
     * Gets all the students from a company.
     * Only the tutor of the company or the supervisor can obtain this information.
     * @param id, Id of the company.
     * @param username, Username of the user trying to obtain this information. 
     * @return A list with all the students from the company.
     */
    public List<Student> getStudentsInCompany(Long id, String username) {
        if (!tutorService.isAuthorized(username, id) && !supervisorService.isAuthorized(username)) {
            return null;
        }
        return studentService.getStudentsFromCompany(id);
    }

    /**
     * Gets the history of practices of a company.
     * Those practices that have been done or are being done in the company.
     * Only the tutor of the company or the supervisor can obtain this information.
     * @param id, Id of the company.
     * @param username, Username of the user trying to obtain this information.
     * @return A list with the history of practices of the company.
     */
    public List<Practice> getPracticeHistory(Long id, String username) {
        if (!tutorService.isAuthorized(username, id) && !supervisorService.isAuthorized(username)) {
            return null;
        }
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
