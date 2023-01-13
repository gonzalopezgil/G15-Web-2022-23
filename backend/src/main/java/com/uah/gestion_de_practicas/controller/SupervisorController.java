package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uah.gestion_de_practicas.controller.dto.SupervisorDTO;
import com.uah.gestion_de_practicas.model.Supervisor;
import com.uah.gestion_de_practicas.service.SupervisorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/** 
 * Rest Controller for the Supervisor endpoint
 */
@RestController
@Slf4j
@RequestMapping("/api/users/supervisors")
public class SupervisorController {

    /** 
     * Service to manage the supervisors
     */
    private final SupervisorService supervisorService;
    
    /**
     * Constructor of the class
     * @param supervisorService, the service to manage the supervisors
     */
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    /** 
     * Endpoint to get a list with all the supervisors in the database
     * @return a list with all the supervisors in the database
     */
    @GetMapping("")
    @ApiOperation("Get all supervisors")
    public ResponseEntity<List<SupervisorDTO>> getSupervisors() {
        log.info("List of all the supervisors obtained successfully");
        return ResponseEntity.ok(SupervisorDTO.fromSupervisors(supervisorService.getAllSupervisors()));
    }

    /** 
     * Endpoint to get a supervisor by id
     * @param id, the id of the supervisor
     * @return the supervisor with the id passed as parameter
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a supervisor by id")
    public ResponseEntity<SupervisorDTO> getSupervisorById(@ApiParam("Identifier of the supervisor") @PathVariable Long id) {
        log.info("Supervisor obtained by id successfully");
        return ResponseEntity.ok(SupervisorDTO.fromSupervisor(supervisorService.getSupervisor(id)));
    }

    /** 
     * Endpoint to update a supervisor
     * @param id, the id of the supervisor
     * @param supervisor, the new object for the supervisor
     * @return a response entity with the status of the operation
     */
    @PutMapping("/{id}")
    @ApiOperation("Update a supervisor by id")
    public ResponseEntity<Void> updateSupervisor(@ApiParam("Identifier of the supervisor") @PathVariable Long id, @ApiParam("New object for the supervisor") @RequestBody Supervisor supervisor) {
        if (supervisor.getId() != id) {
            log.warn("Bad request updating a supervisor by id: the id of the supervisor doesn't match with the id passed as parameter");
            return ResponseEntity.badRequest().build();
        }
        log.info("Supervisor updated successfully");
        supervisorService.saveSupervisor(supervisor);
        return ResponseEntity.ok().build();
    }

    /** 
     * Endpoint to delete a supervisor by id
     * @param id, the id of the supervisor
     * @return a response entity with the status of the operation
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a supervisor by id")
    public ResponseEntity<Void> deleteSupervisor(@ApiParam("Identifier of the supervisor") @PathVariable Long id) {
        if (supervisorService.getSupervisor(id) == null) {
            log.warn("Not found deleting a supervisor by id: the id of the supervisor doesn't match with any supervisor in the database");
            return ResponseEntity.notFound().build();
        }
        log.info("Supervisor deleted successfully");
        supervisorService.deleteSupervisor(id);
        return ResponseEntity.ok().build();
    }

    
}