package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.PracticeAssignmentDTO;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;
import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.service.PracticeService;
import com.uah.gestion_de_practicas.service.RequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Rest Controller for the Practice endpoint
 */
@RestController
@RequestMapping("/api/practices")
public class PracticeController {
    private final PracticeService practiceService;
    private final RequestService requestService;
    private final OfferService offerService;

    public PracticeController(PracticeService practiceService, RequestService requestService, OfferService offerService) {
        this.practiceService = practiceService;
        this.requestService = requestService;
        this.offerService = offerService;
    }

    /**
     * Endpoint to obtain a list of all the practices
     * @return a list of all the practices
     */
    @GetMapping("")
    @ApiOperation("Get all the practices")
    public ResponseEntity <List<SimplePracticeDAO>> getPractices() {
        return ResponseEntity.ok(practiceService.getAllPractices());
    }

    /**
     * Endpoint to obtain a practice by its id
     * @param id, the id of the practice
     * @return the practice with the given id
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a practice by its id")
    public ResponseEntity<SimplePracticeDAO> getPracticeById(@ApiParam("The id of the practice") @PathVariable Long id) {
        return ResponseEntity.ok(practiceService.getPractice(id));
    }

    /**
     * Endpoint to save a new practice
     * @param practice, the practice to be saved
     * @return the saved practice
     */
    @PostMapping("")
    @ApiOperation("Save a new practice")
    public ResponseEntity<Practice> savePractice(@ApiParam("The practice to be saved") @RequestBody Practice practice) {
        return ResponseEntity.ok(practiceService.savePractice(practice));
    }


    /**
     * Endpoint to delete a practice by its id
     * @param id, the id of the practice
     * @return the deleted practice
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a practice by its id")
    public ResponseEntity<String> deletePractice(@ApiParam("The id of the practice to be deleted") @PathVariable Long id) {  
        practiceService.deletePractice(id);
        return ResponseEntity.ok("Practice "+ id + " deleted");
    }


    /**
     * Endpoint to assign available offers to students with 
     * greater exp_grades.
     * @return a list of practices with the assigned offers
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/assignation")
    @ApiOperation("Assign available offers to students with greater exp_grades")
    public ResponseEntity<List<PracticeAssignmentDTO>> assignPractices(){
        List<Practice> practices = requestService.getPracticeAssignments();
        practices = practiceService.saveAllPractices(practices);
        
        for (Practice practice : practices) {
            offerService.saveOffer(practice.getOffer());
        }

        List<PracticeAssignmentDTO> assignmentDTO = PracticeAssignmentDTO.fromPractices(practices);
        return ResponseEntity.ok(assignmentDTO);
    }
    
    /**
     * Endpoint to obtain a report of all the practices completed and their evaluation
     * @return a list of practices with the assigned offers
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/report")
    @ApiOperation("Obtain a report of all the practices completed and their evaluation")
    public ResponseEntity<List<SimplePracticeDAO>> getPracticesReport(){
        List<SimplePracticeDAO> practices = practiceService.getReport();
        return ResponseEntity.ok(practices);
    }
}