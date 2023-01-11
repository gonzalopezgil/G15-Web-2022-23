package com.uah.gestion_de_practicas.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.controller.dto.PracticeDTO;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.PracticeRepository;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;

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

    /** 
     * Service class for the Tutor class.
     */
    private final TutorService tutorService;


    public PracticeService(PracticeRepository practiceRepository, TutorService tutorService) {
        this.practiceRepository = practiceRepository;
        this.tutorService = tutorService;
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
    public SimplePracticeDAO getPractice(Long id) {
        return practiceRepository.findPracticeById(id).orElse(null);
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
    public List<SimplePracticeDAO> getAllPractices() {
        return practiceRepository.findAllPractices();
    }

    /**
     * Saves a list of practices in the database.
     * Only the tutor of the company can save this information.
     * @param practices, List of practices to be saved.
     * @param tutor_username, Username of the tutor.
     * @return A list with all the saved practices.
     */
    public List<Practice> saveAllPractices(List<PracticeDTO> practices, String tutor_username) {
        HashMap<Long, PracticeDTO> map = new HashMap<>();
        for (PracticeDTO p: practices) {
            map.put(p.getId(), p);
        }
        List<Practice> practices_all_info = practiceRepository.findAllById(map.keySet());
        for (Practice p : practices_all_info) {
            PracticeDTO p_dto = map.get(p.getId());
            p.setMark(p_dto.getMark());
            p.setReport(p_dto.getReport());
            p.setEnd_date(Date.valueOf(LocalDate.now()));
        }

        // Security check
        List<Long> practices_ids = new ArrayList<>();
        practices_ids.addAll(map.keySet());
        if (!tutorService.isAuthorized(tutor_username, practices_ids)) {
            return null;
        }

        return practiceRepository.saveAll(practices_all_info);
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
    public List<SimplePracticeDAO> getReport(){
        return practiceRepository.getCompletedPractices();
    }
}
