package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uah.gestion_de_practicas.controller.dto.TutorDTO;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;
import com.uah.gestion_de_practicas.service.TutorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/users/tutors")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("")
    @ApiOperation("Get all the tutors registered in the database.")
    public ResponseEntity<List<TutorDAO>> getTutors() {
        return ResponseEntity.ok(tutorService.getAllTutors());
    }

    @PostMapping("")
    @ApiOperation("Create a new tutor.")
    public ResponseEntity saveTutor(@ApiParam("Object with the new tutor") @RequestBody Tutor tutor) {
        if (tutorService.getTutor(tutor.getId()) != null) {
            return ResponseEntity.badRequest().build();
        }
        
        tutorService.saveTutor(tutor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a tutor by its id.")
    public ResponseEntity<TutorDAO> getTutorById(@ApiParam("Identifier of the tutor") @PathVariable Long id) {
        if (tutorService.getTutor(id) == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(tutorService.getTutor(id));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a tutor by its id.")
    public ResponseEntity updateTutor(@ApiParam("Identifier of the tutor") @PathVariable Long id, @ApiParam("New tutor's attributes") @RequestBody TutorDTO tutor) {
        if (tutor.getUser_id() != id) {
            return ResponseEntity.badRequest().build();
        }

        tutorService.updateTutor(tutor.toTutor());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a tutor by its id.")
    public ResponseEntity deleteTutor(@ApiParam("Identifier of the tutor") @PathVariable Long id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.ok().build();
    }

}
