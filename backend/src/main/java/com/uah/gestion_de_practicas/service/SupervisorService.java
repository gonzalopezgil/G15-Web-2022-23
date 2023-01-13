package com.uah.gestion_de_practicas.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.uah.gestion_de_practicas.model.Supervisor;
import com.uah.gestion_de_practicas.repository.SupervisorRepository;


/**
 * Service class for the Supervisor class.
 * Implements the business logic for the Supervisor class.
 */

@Service
public class SupervisorService {
    
   /**
     * Data access repository for the Supervisor class.
    */
    private final SupervisorRepository supervisorRepository;

    public SupervisorService(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a Supervisor in the database.
     */
    public Supervisor saveSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    /**
     * Gets a Supervisor from the database.
     * @param id Id of the Supervisor to be retrieved.
     */
    public Supervisor getSupervisor(Long id) {
        return supervisorRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a Supervisor from the database.
     * @param id Id of the Supervisor to be deleted.
     */
    public void deleteSupervisor(Long id) {
        supervisorRepository.deleteById(id);
    }

    /**
     * Gets all the tutors from the database.
     * @return A list with all the Supervisors.
     */
    public List<Supervisor> getAllSupervisors() {
        return supervisorRepository.findAll();
    }

    // ------------------- CUSTOM OPERATIONS ------------------- //

    /** 
     * Checks if the supervisor is authorized to access the information.
     * @param username Username of the supervisor.
     * @return True if the supervisor is authorized, false otherwise.
     */
    public boolean isAuthorized(String username) {
        Supervisor supervisor = supervisorRepository.findSupervisorByUsername(username).orElse(null);
        if (supervisor == null) return false;
        return (supervisor.getRemoval_date() == null);
    }
}
