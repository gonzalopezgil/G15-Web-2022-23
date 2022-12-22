package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.TutorRepository;

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
    public Tutor getTutor(Long id) {
        return tutorRepository.findById(id).orElse(null);
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
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }
    
}
