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
}
