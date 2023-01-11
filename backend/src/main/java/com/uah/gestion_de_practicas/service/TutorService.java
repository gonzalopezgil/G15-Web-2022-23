package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.TutorRepository;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;

/**
 * Service class for the Tutor class.
 * Implements the business logic for the Tutor class.
 */
@Service
public class TutorService {

    /**
     * Data access repository for the Tutor class.
     */
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a tutor in the database.
     */
    public Tutor saveTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    /**
     * Gets a tutor from the database.
     * @param id Id of the tutor to be retrieved.
     */
    public TutorDAO getTutor(Long id) {
        return tutorRepository.getTutorById(id).orElse(null);
    }

    /**
     * Updates a tutor in the database.
     * @param id Id of the tutor to be updated.
     * @param tutor Tutor object with the new data.
     */
    public void updateTutor(Tutor tutor) {
        tutorRepository.save(tutor);
    }

    /**
     * Deletes a tutor from the database.
     * @param id Id of the tutor to be deleted.
     */
    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }

    /**
     * Gets all the tutors from the database.
     * @return A list with all the tutors.
     */
    public List<TutorDAO> getAllTutors() {
        return tutorRepository.getAllTutors();
    }

    // ------------------- CUSTOM OPERATIONS ---------------- //

    /** 
     * Checks if a tutor is authorized to access the information.
     * @param username Username of the tutor.
     * @return True if the tutor is authorized, false otherwise.
     */
    public boolean isAuthorized(String username) {
        Tutor tutor = tutorRepository.findTutorByUsername(username).orElse(null);
        if (tutor == null)
            return false;
        return (tutor.getRemoval_date() == null);
    }
    
    /** 
     * Checks if a tutor is authorized to modify the information of a company.
     * @param username Username of the tutor.
     * @param company_id Id of the company.
     * @return True if the tutor is authorized, false otherwise.
     */
    public boolean isAuthorized(String username, Long company_id) {
        Tutor tutor = tutorRepository.findTutorByUsername(username).orElse(null);
        if (tutor == null || tutor.getCompany().getId() != company_id) return false;
        return (tutor.getRemoval_date() == null);
    }

    /** 
     * Updates the company of a tutor.
     * @param username Username of the tutor to be updated.
     * @param company Company object with the information of the new company.
     * @return The updated tutor.
     */
    public Tutor updateTutorCompany(String username, Company company) {
        Tutor tutor = tutorRepository.findTutorByUsername(username).orElse(null);
        if (tutor == null) return null;
        tutor.setCompany(company);
        return tutorRepository.save(tutor);
    }
    
}
