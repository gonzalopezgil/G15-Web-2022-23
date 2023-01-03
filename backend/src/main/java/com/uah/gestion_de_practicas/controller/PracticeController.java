package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.PracticeAssignmentDTO;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.service.PracticeService;
import com.uah.gestion_de_practicas.service.RequestService;

/**
 * Rest Controller for the Practice endpoint
 */
@RestController
@RequestMapping("/api/practice")
public class PracticeController {
    private final PracticeService practiceService;
    private final RequestService requestService;

    public PracticeController(PracticeService practiceService, RequestService requestService) {
        this.practiceService = practiceService;
        this.requestService = requestService;
    }

    /**
     * Endpoint to obtain a list of all the practices
     * @return a list of all the practices
     */
    @GetMapping("")
    public ResponseEntity<List<Practice>> getPractices() {
        return ResponseEntity.ok(practiceService.getAllPractices());
    }

    /**
     * Endpoint to obtain a practice by its id
     * @param id, the id of the practice
     * @return the practice with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long id) {
        return ResponseEntity.ok(practiceService.getPractice(id));
    }

    /**
     * Endpoint to save a new practice
     * @param practice, the practice to be save
     * @return the saved practice
     */
    @PostMapping("")
    public ResponseEntity<Practice> savePractice(@RequestBody Practice practice) {
        return ResponseEntity.ok(practiceService.savePractice(practice));
    }


    /**
     * Endpoint to delete a practice by its id
     * @param id, the id of the practice
     * @return the deleted practice
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Practice> deletePractice(@PathVariable Long id) {
        practiceService.deletePractice(id);
        return ResponseEntity.ok().build();
    }


    /**
     * Endpoint to assign available offers to students with 
     * greater exp_grades.
     * @return a list of practices with the assigned offers
     */
    @PostMapping("/assignation")
    public ResponseEntity<List<PracticeAssignmentDTO>> assignPractices() {
        List<Practice> practices = requestService.getPracticeAssignments();
        practiceService.saveAllPractices(practices);
        
        List<PracticeAssignmentDTO> assignmentDTO = PracticeAssignmentDTO.fromPractices(practices);
        return ResponseEntity.ok(assignmentDTO);
    }
    
    /**
     * Endpoint to obtain a report of all the practices completed and their evaluation
     * @return a list of practices with the assigned offers
     */
    @GetMapping("/report")
    public ResponseEntity<List<Practice>> getPracticesReport() {
        List<Practice> practices = practiceService.getReport();
        return ResponseEntity.ok(practices);
    }
}