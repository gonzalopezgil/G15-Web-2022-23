package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uah.gestion_de_practicas.controller.dto.TutorDTO;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;
import com.uah.gestion_de_practicas.service.TutorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Rest Controller for the Tutor endpoint
 */
@RestController
@RequestMapping("/api/users/tutors")
public class TutorController {

    /** 
     * Service to manage the tutor's data.
     */
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    /** 
     * Endpoint to get all the tutors registered in the database.
     * Only the supervisor can get all the tutors.
     * @return a list with all the tutors.
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("")
    @ApiOperation("Get all the tutors registered in the database.")
    public ResponseEntity<List<TutorDAO>> getTutors() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<TutorDAO> tutors = tutorService.getAllTutors(username);
        if (tutors == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(tutors);
    }

    /** 
     * Endpoint to register a new tutor.
     * Open to everyone.
     * @param tutor, the tutor to be registered.
     * @return the tutor registered.
     */
    @PostMapping("")
    @ApiOperation("Create a new tutor.")
    public ResponseEntity<Void> saveTutor(@ApiParam("Object with the new tutor") @RequestBody TutorDTO tutor) {
        if (tutor == null || tutor.getUser_id() != null || tutorService.getTutor(tutor.getUser_id()) != null) {
            return ResponseEntity.badRequest().build();
        }
        
        tutorService.saveTutor(TutorDTO.toTutor(tutor));
        return ResponseEntity.ok().build();
    }

    /** 
     * Endpoint to get a tutor by its id.
     * Only the tutor itself and the supervisor can obtain the information.
     * @param id, the id of the tutor.
     */
    @GetMapping("/{id}")
    @ApiOperation("Get a tutor by its id.")
    public ResponseEntity<TutorDAO> getTutorById(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id) {
        if (id == null || tutorService.getTutor(id) == null) {
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        TutorDAO tutor = tutorService.getTutor(id, username);
        if (tutor == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(tutor);
    }

    @ApiIgnore
    @PutMapping("/{id}")
    @ApiOperation("Update a tutor by its id.")
    public ResponseEntity<Void> updateTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id, @ApiParam("New tutor's attributes") @RequestBody TutorDTO tutor) {
        if (tutor.getUser_id() != id) {
            return ResponseEntity.badRequest().build();
        }

        tutorService.updateTutor(tutor.toTutor());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a tutor by its id.")
    public ResponseEntity<Void> deleteTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.ok().build();
    }

}
