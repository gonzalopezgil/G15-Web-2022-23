package com.uah.gestion_de_practicas.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.TutorRepository;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;
import com.uah.gestion_de_practicas.repository.dao.TutorPerPracticeDAO;

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
     * Checks if a tutor is authorized to modify or access the information of a company.
     * @param username Username of the tutor.
     * @param company_id Id of the company.
     * @return True if the tutor is authorized, false otherwise.
     */
    public boolean isAuthorized(String username, Long company_id) {
        Tutor tutor = tutorRepository.findTutorByUsername(username).orElse(null);
        if (tutor == null || tutor.getCompany().getId() != company_id)
            return false;
        return (tutor.getRemoval_date() == null);
    }
    
    /** 
     * Checks if a tutor is authorized to modify or access the information of a list of practices.
     * @param username, Username of the tutor.
     * @param practices_ids, List of practices ids.
     * @return True if the tutor is authorized, false otherwise.
     */
    public boolean isAuthorized(String username, List<Long> practices_ids) {
        List<String> tutors_username = tutorRepository.getTutorOfPractices(practices_ids);
        if (tutors_username.size() == 0 || !tutors_username.contains(username)) {
            return false;
        }
        return true;
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

    public HashMap<Long, String> getTutorByPractice(List<Practice> practices) {
        HashMap<Long, String> tutors = new HashMap<>();
        for (Practice practice : practices) {
            tutors.put(practice.getId(), tutorRepository.getTutorByCompany(practice.getOffer().getCompany().getId()).getCompleteName());
        }

        return tutors;
    }
}
