package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/users/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
    public ResponseEntity deleteStudent(@ApiParam("Identifier of the student") @PathVariable Long id) {
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
}
