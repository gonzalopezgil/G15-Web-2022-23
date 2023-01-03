package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.PracticeRepository;

/**
 * Service class for the Practice class.
 * Implements the business logic for the Practice class.
 */
@Service
public class PracticeService {

    /**
     * Data access repository for the Practice class.
     */
    private final PracticeRepository practiceRepository;

    public PracticeService(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a practice in the database.
     */
    public Practice savePractice(Practice practice) {
        return practiceRepository.save(practice);
    }

    /**
     * Gets a practice from the database.
     * @param id, Id of the practice to be retrieved.
     */
    public Practice getPractice(Long id) {
        return practiceRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a practice from the database.
     * @param id, Id of the practice to be deleted.
     */
    public void deletePractice(Long id) {
        practiceRepository.deleteById(id);
    }

    /**
     * Gets all the practices from the database.
     * @return A list with all the practices.
     */
    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    /**
     * Saves a list of practices in the database.
     * @param practices, List of practices to be saved.
     * @return A list with all the saved practices.
     */
    public List<Practice> saveAllPractices(List<Practice> practices) {
        return practiceRepository.saveAll(practices);
    }

    // ------------------- SPECIFIC OPERATIONS ------------------- //

    /**
     * Gets the practice history of the company.
     * Done or in progress practices.
     * @param id, Id of the student.
     * @return A list with all the practices of the student.
     */
    public List<Practice> getPracticeHistory(Long id) {
        return practiceRepository.getPracticeHistory(id);
    }

    /**
     * Gets the practices that are completed.
     * @return A list with all the completed practices.
     */
    public List<Practice> getReport(){
        return practiceRepository.getCompletedPractices();
    }
}
