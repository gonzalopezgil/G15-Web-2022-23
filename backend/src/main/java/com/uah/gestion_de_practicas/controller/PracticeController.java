package com.uah.gestion_de_practicas.controller;

import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.PracticeAssignmentDTO;
import com.uah.gestion_de_practicas.handlers.PDFHandler;
import com.uah.gestion_de_practicas.handlers.PracticeAssignmentHandler;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;
import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.service.PracticeService;
import com.uah.gestion_de_practicas.service.RequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;

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
     * Only the supervisor can access this information
     * @return a list of all the practices
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("")
    @ApiOperation("Get all the practices")
    public ResponseEntity<List<SimplePracticeDAO>> getPractices() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<SimplePracticeDAO> practices = practiceService.getAllPractices(username);
        if (practices == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(practices);
    }

    /**
     * Endpoint to obtain a practice by its id
     * Only the tutor of the practice or the supervisor can access this information
     * @param id, the id of the practice
     * @return the practice with the given id
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a practice by its id")
    public ResponseEntity<SimplePracticeDAO> getPracticeById(@ApiParam("The id of the practice") @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        SimplePracticeDAO practice = practiceService.getPractice(id, username);
        if (practice == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(practice);
    }

    
    /**
     * Endpoint to save a new practice
     * @param practice, the practice to be saved
     * @return the saved practice
     */
    // @ApiIgnore
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
    // @ApiIgnore
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a practice by its id")
    public ResponseEntity<String> deletePractice(@ApiParam("The id of the practice to be deleted") @PathVariable Long id) {  
        practiceService.deletePractice(id);
        return ResponseEntity.ok("Practice "+ id + " deleted");
    }


    /**
     * Endpoint to assign available offers to students with 
     * greater exp_grades.
     * Only the supervisor can execute the assignment
     * @return a list of practices with the assigned offers
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/assign-practices")
    @ApiOperation("Assign available offers to students with greater exp_grades")
    public ResponseEntity<List<PracticeAssignmentDTO>> assignPractices(){
        List<Practice> practices = requestService.getPracticeAssignments();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        practices = practiceService.saveAllPractices(practices, username);
        if (practices.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        for (Practice practice : practices) {
            offerService.saveOffer(practice.getOffer());
        }

        List<PracticeAssignmentDTO> assignmentDTO = PracticeAssignmentDTO.fromPractices(practices);

        PracticeAssignmentHandler handler = new PracticeAssignmentHandler(practices);
        handler.generatePDF();

        return ResponseEntity.ok(assignmentDTO);
    }

    /**
     * Endpoint to download the latest practice assignation of students
     * Only the supervisor can access this endpoint
     * @return a pdf file with the latest assignation
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/assignation")
    @ApiOperation("Download the latest assignation of practices")
    public ResponseEntity downloadAssignation(HttpServletResponse response){
        response.setContentType("application/pdf");
        Date now = new Date();
        String currentDateTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(now);
        String headerValue = String.format("attachment; filename=\"%s\"", "asignacion_" + currentDateTime + ".pdf");
        response.setHeader("Content-Disposition", headerValue);

        try {
            PracticeAssignmentHandler handler = new PracticeAssignmentHandler();
            handler.downloadPdf(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().build();
    }
   
    
    /**
     * Endpoint to obtain a report of all the practices completed and their evaluation
     * Only the supervisor can access this endpoint
     * @return a list of practices with the assigned offers
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/report")
    @ApiOperation("Obtain a report of all the practices completed and their evaluation")
    public ResponseEntity<List<SimplePracticeDAO>> getPracticesReport() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<SimplePracticeDAO> practices = practiceService.getReport(username);
        if (practices == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(practices);
    }
}