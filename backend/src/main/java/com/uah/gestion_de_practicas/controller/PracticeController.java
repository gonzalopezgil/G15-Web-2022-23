package com.uah.gestion_de_practicas.controller;

import java.util.Date;
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
import com.uah.gestion_de_practicas.controller.dto.PracticeDTO;
import com.uah.gestion_de_practicas.handlers.PracticeAssignmentHandler;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;
import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.service.PracticeService;
import com.uah.gestion_de_practicas.service.RequestService;
import com.uah.gestion_de_practicas.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for the Practice endpoint
 */
@RestController
@Slf4j
@RequestMapping("/api/practices")
public class PracticeController {
    /** 
     * Service to manage the practices
     */
    private final PracticeService practiceService;

    /**
     * Service to manage the requests
     */
    private final RequestService requestService;

    /**
     * Service to manage the offers
     */
    private final OfferService offerService;

    /**
     * Service to manage the students
     */
    private final StudentService studentService;

    /**
     * Constructor of the class
     * @param practiceService, the service to manage the practices
     * @param requestService, the service to manage the requests
     * @param offerService, the service to manage the offers
     */
    public PracticeController(PracticeService practiceService, RequestService requestService, OfferService offerService, StudentService studentService) {
        this.practiceService = practiceService;
        this.requestService = requestService;
        this.offerService = offerService;
        this.studentService = studentService;
    }

    /**
     * Endpoint to obtain a list of all the practices
     * @return a list of all the practices
     */
    @GetMapping("")
    @ApiOperation("Get all the practices")
    public ResponseEntity<List<SimplePracticeDAO>> getPractices() {
        log.info("All the practices obtained successfully");
        return ResponseEntity.ok(practiceService.getAllPractices());
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
            log.warn("Bad request to get a practice by id: id is null");
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        SimplePracticeDAO practice = practiceService.getPractice(id, username);
        if (practice == null) {
            log.warn("The user does not have access to the practice requested by id");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Practice obtained by id successfully");
        return ResponseEntity.ok(practice);
    }

    
    /**
     * Endpoint to save a new practice
     * @param practice, the practice to be saved
     * @return the saved practice
     */
    @PostMapping("")
    @ApiOperation("Save a new practice")
    public ResponseEntity<PracticeDTO> savePractice(@ApiParam("The practice to be saved") @RequestBody PracticeDTO practiceDTO) {
        log.info("Practice saved successfully");
        // Fetch the student and offer from the database
        Student student = studentService.getStudent(practiceDTO.getStudent_id());
        Offer offer = offerService.getOffer(practiceDTO.getOffer_id());

        // Create the new practice
        Practice practice = new Practice();
        practice.setStudent(student);
        practice.setOffer(offer);
        practice.setId(practiceDTO.getId());
        practice.setMark(practiceDTO.getMark());
        practice.setReport(practiceDTO.getReport());
        practice.setStart_date(practiceDTO.getStart_date());
        practice.setEnd_date(practiceDTO.getEnd_date());
        
        return ResponseEntity.ok(PracticeDTO.fromPractice(practiceService.savePractice(practice)));
    }


    /**
     * Endpoint to delete a practice by its id
     * @param id, the id of the practice
     * @return the deleted practice
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a practice by its id")
    public ResponseEntity<String> deletePractice(@ApiParam("The id of the practice to be deleted") @PathVariable Long id) {  
        log.info("Practice deleted successfully");
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
            log.warn("Not found any practice to assign");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        for (Practice practice : practices) {
            offerService.saveOffer(practice.getOffer());
        }

        List<PracticeAssignmentDTO> assignmentDTO = PracticeAssignmentDTO.fromPractices(practices);

        PracticeAssignmentHandler handler = new PracticeAssignmentHandler(practices);
        handler.generatePDF();

        log.info("Practices assigned successfully");
        return ResponseEntity.ok(assignmentDTO);
    }

    /**
     * Endpoint to download the latest practice assignation of students
     * Only the supervisor can access this endpoint
     * @param response, the response of the request
     * @return a pdf file with the latest assignation
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/assignation")
    @ApiOperation("Download the latest assignation of practices")
    public ResponseEntity<Void> downloadAssignation(HttpServletResponse response){
        response.setContentType("application/pdf");
        Date now = new Date();
        String currentDateTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(now);
        String headerValue = String.format("attachment; filename=\"%s\"", "asignacion_" + currentDateTime + ".pdf");
        response.setHeader("Content-Disposition", headerValue);

        try {
            PracticeAssignmentHandler handler = new PracticeAssignmentHandler();
            handler.downloadPdf(response);
        } catch (Exception e) {
            log.error("Impossible to download the assignation");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Assignation downloaded successfully");
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
            log.warn("The user does not have access to the report");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Report obtained successfully");
        return ResponseEntity.ok(practices);
    }
}