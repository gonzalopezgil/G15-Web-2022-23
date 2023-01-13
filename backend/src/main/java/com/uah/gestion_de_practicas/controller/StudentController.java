package com.uah.gestion_de_practicas.controller;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.OfferSelection;
import com.uah.gestion_de_practicas.controller.dto.StudentDTO;
import com.uah.gestion_de_practicas.handlers.PDFHandler;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.service.StudentService;
import com.uah.gestion_de_practicas.service.TutorService;
import com.uah.gestion_de_practicas.handlers.UserReportHandler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/** 
 * Rest Controller for the Student endpoint
 */
@RestController
@Slf4j
@RequestMapping("/api/users/students")
public class StudentController {

    /** 
     * Service to manage the students
     */
    private final StudentService studentService;

    /**
     * Service to manage the tutors
     */
    private final TutorService tutorService;

    /**
     * Constructor of the class
     * @param studentService, the service to manage the students
     * @param tutorService, the service to manage the tutors
     */
    public StudentController(StudentService studentService, TutorService tutorService) {
        this.studentService = studentService;
        this.tutorService = tutorService;
    }

    /** 
     * Endpoint to get a list with all the students in the database
     * @return a list with all the students in the database
     */
    @GetMapping("")
    @ApiOperation("Get a list with all the students in the database.")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        log.info("List of all the students obtained successfully");
        return ResponseEntity.ok(StudentDTO.fromStudents(studentService.getAllStudents()));
    }

    /** 
     * Endpoint to get a student by its id
     * @param id, the id of the student
     * @return the student with the given id
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a student by its id.")
    public ResponseEntity<StudentDTO> getStudentById(@ApiParam("Identifier of the student") @PathVariable Long id) {
        log.info("Student obtained by id successfully");
        return ResponseEntity.ok(StudentDTO.fromStudent(studentService.getStudent(id)));
    }

    /** 
     * Endpoint to update a student by its id
     * @param id, the id of the student
     * @param student, the modified student
     * @return the modified student
     */
    @PutMapping("/{id}")
    @ApiOperation("Update a student by its id.")
    public ResponseEntity<StudentDTO> updateStudent(@ApiParam("Identifier of the student") @PathVariable Long id, @ApiParam("Modified Student object") @RequestBody Student student) {
        if (!id.equals(student.getId())) {
            log.warn("Bad request to update a student: id in the path does not match the id in the body");
            return ResponseEntity.badRequest().build();
        }
        log.info("Student updated successfully");
        return ResponseEntity.ok(StudentDTO.fromStudent(studentService.saveStudent(student)));
    }

    /** 
     * Endpoint to delete a student by its id
     * @param id, the id of the student
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a student by its id.")
    public ResponseEntity<Void> deleteStudent(@ApiParam("Identifier of the student") @PathVariable Long id) {
        if (studentService.getStudent(id) == null) {
            log.warn("Bad request to delete a student: student does not exist");
            return ResponseEntity.notFound().build();
        }
        log.info("Student deleted successfully");
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    /** 
     * Endpoint to get a list with all the offers selected by a student
     * @param id, the id of the student
     * @return a list with all the offers selected by a student
     */
    @GetMapping("/{id}/selection")
    @ApiOperation("Get a list with all the offers selected by a student.")
    public ResponseEntity<List<OfferSelection>> getOfferSelections(@ApiParam("Identifier of the student") @PathVariable Long id) {
        if (studentService.getStudent(id) == null) {
            log.warn("Bad request to get the offer selection of a student: student does not exist");
            return ResponseEntity.notFound().build();
        }
        log.info("List of all the offers selected by a student obtained successfully");
        return ResponseEntity.ok(OfferSelection.fromRequests(studentService.getRequestsByStudentId(id)));
    }

    /** 
     * Endpoint to publish a student's new offer selection
     * @param id, the id of the student
     * @param offerSelections, the list of offer selections
     * @return the list of offer selections
     */
    @PostMapping("/{id}/selection")
    @ApiOperation("Publish a student's new offer selection.")
    public ResponseEntity<List<OfferSelection>> selectOffers(@ApiParam("Identifier of the student") @PathVariable Long id, @ApiParam("List of offer selections") @RequestBody List<OfferSelection> offerSelections) {
        if (studentService.getStudent(id) == null) {
            log.warn("Bad request to publish a student's new offer selection: student does not exist");
            return ResponseEntity.notFound().build();
        }

        if (!studentService.isAvailableForPractice(id)) {
            log.warn("Bad request to publish a student's new offer selection: student is not available for practice");
            return ResponseEntity.badRequest().build();
        }
        log.info("Student's new offer selection published successfully");
        return ResponseEntity.ok(OfferSelection.fromRequests(studentService.selectOffers(id, offerSelections)));
    }

    /** 
     * Endpoint to obtain a report document of a student's practices
     * @param id, the id of the student
     * @param response, the response
     */
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/{id}/report")
    @ApiOperation("Obtain a report document of a student's practices")
    public ResponseEntity<Void> generateReport(@ApiParam("The id of the student") @PathVariable Long id, HttpServletResponse response) {
        
        response.setContentType("application/pdf");
        Date now = new Date();
        String currentDateTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(now);
        String headerValue = String.format("attachment; filename=\"%s\"", "report_" + currentDateTime + ".pdf");

        response.setHeader("Content-Disposition", headerValue);

        Student student = studentService.getStudent(id);
        if (student == null) {
            log.warn("Not found to generate a report: student does not exist");
            return ResponseEntity.notFound().build();
        }

        List<Practice> completedPractices = studentService.getCompletedPractices(student.getId());
        HashMap<Long, String> tutors = tutorService.getTutorByPractice(completedPractices);

        try{
            PDFHandler pdfHandler = new UserReportHandler(student, completedPractices, tutors);
            pdfHandler.generatePDF(response.getOutputStream());
        } catch (Exception e) {
            log.error("Error generating the report: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        log.info("Report generated successfully");
        return ResponseEntity.ok().build();
    }
}
