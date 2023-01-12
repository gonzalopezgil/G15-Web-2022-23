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

@RestController
@RequestMapping("/api/users/students")
public class StudentController {
    private final StudentService studentService;
    private final TutorService tutorService;

    public StudentController(StudentService studentService, TutorService tutorService) {
        this.studentService = studentService;
        this.tutorService = tutorService;
    }

    @GetMapping("")
    @ApiOperation("Get a list with all the students in the database.")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(StudentDTO.fromStudents(studentService.getAllStudents()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a student by its id.")
    public ResponseEntity<StudentDTO> getStudentById(@ApiParam("Identifier of the student") @PathVariable Long id) {
        return ResponseEntity.ok(StudentDTO.fromStudent(studentService.getStudent(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@ApiParam("Identifier of the student") @PathVariable Long id, @ApiParam("Modified Student object") @RequestBody Student student) {
        if (!id.equals(student.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(StudentDTO.fromStudent(studentService.saveStudent(student)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a student by its id.")
    public ResponseEntity<Void> deleteStudent(@ApiParam("Identifier of the student") @PathVariable Long id) {
        if (studentService.getStudent(id) == null) {
            return ResponseEntity.notFound().build();
        }

        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/selection")
    @ApiOperation("Get a list with all the offers selected by a student.")
    public ResponseEntity<List<OfferSelection>> getOfferSelections(@ApiParam("Identifier of the student") @PathVariable Long id) {
        if (studentService.getStudent(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(OfferSelection.fromRequests(studentService.getRequestsByStudentId(id)));
    }

    @PostMapping("/{id}/selection")
    @ApiOperation("Publish a student's new offer selection.")
    public ResponseEntity<List<OfferSelection>> selectOffers(@ApiParam("Identifier of the student") @PathVariable Long id, @ApiParam("List of offer selections") @RequestBody List<OfferSelection> offerSelections) {
        if (studentService.getStudent(id) == null) {
            return ResponseEntity.notFound().build();
        }

        if (!studentService.isAvailableForPractice(id)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(OfferSelection.fromRequests(studentService.selectOffers(id, offerSelections)));
    }

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
            return ResponseEntity.notFound().build();
        }

        List<Practice> completedPractices = studentService.getCompletedPractices(student.getId());
        HashMap<Long, String> tutors = tutorService.getTutorByPractice(completedPractices);

        try{
            PDFHandler pdfHandler = new UserReportHandler(student, completedPractices, tutors);
            pdfHandler.generatePDF(response.getOutputStream());
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
