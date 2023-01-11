package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    
}
