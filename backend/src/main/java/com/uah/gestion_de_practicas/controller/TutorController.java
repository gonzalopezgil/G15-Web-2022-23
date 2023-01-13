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

import com.uah.gestion_de_practicas.controller.dto.OfferDTO;
import com.uah.gestion_de_practicas.controller.dto.PracticeDTO;
import com.uah.gestion_de_practicas.controller.dto.TutorDTO;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.dao.TutorDAO;
import com.uah.gestion_de_practicas.service.TutorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for the Tutor endpoint
 */
@RestController
@Slf4j
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
            log.warn("User does not have permission to get all the tutors.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("All the tutors have been retrieved successfully.");
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
            log.warn("Bad request registering a new tutor");
            return ResponseEntity.badRequest().build();
        }
        log.info("New tutor registered successfully");
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
            log.warn("Tutor not found by id in the database");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        TutorDAO tutor = tutorService.getTutor(id, username);
        if (tutor == null) {
            log.warn("User does not have permission to get the tutor.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Tutor retrieved successfully");
        return ResponseEntity.ok(tutor);
    }

    /** 
     * Endpoint to update a tutor by its id.
     * @param id, the id of the tutor.
     * @param tutor, the new attributes of the tutor.
     * @return a response entity with the status of the response.
     */
    @PutMapping("/{id}")
    @ApiOperation("Update a tutor by its id.")
    public ResponseEntity<Void> updateTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id, @ApiParam("New tutor's attributes") @RequestBody TutorDTO tutor) {
        if (tutor.getUser_id() != id) {
            log.warn("Bad request updating a tutor: id does not match");
            return ResponseEntity.badRequest().build();
        }
        tutorService.updateTutor(tutor.toTutor());
        log.info("Tutor updated successfully");
        return ResponseEntity.ok().build();
    }

    /** 
     * Endpoint to delete a tutor by its id.
     * @param id, the id of the tutor.
     * @return the tutor deleted.
     */ 
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a tutor by its id.")
    public ResponseEntity<Void> deleteTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id) {
        tutorService.deleteTutor(id);
        log.info("Tutor deleted successfully");
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to get all the practices of a tutor.
     * Only the tutor itself and the supervisor can obtain the information.
     * @param id, the id of the tutor.
     * @return a list with all the practices of the tutor.
     */
    @GetMapping("/{id}/practices")
    @ApiOperation("Get all the practices of a tutor.")
    public ResponseEntity<List<PracticeDTO>> getPracticesByTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id) {
        if (id == null || tutorService.getTutor(id) == null) {
            log.warn("Tutor not found by id in the database");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Practice> practices = tutorService.getPracticesByTutor(id, username);
        if (practices == null) {
            log.warn("User does not have permission to get the practices of the tutor.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Practices retrieved successfully");
        return ResponseEntity.ok(PracticeDTO.fromPractices(practices));
    }

    /**
     * Endpoint to get all the offers of a tutor.
     * Only the tutor itself and the supervisor can obtain the information.
     * @param id, the id of the tutor.
     * @return a list with all the offers of the tutor.
     */
    @GetMapping("/{id}/offers")
    @ApiOperation("Get all the offers of a tutor.")
    public ResponseEntity<List<OfferDTO>> getOffersByTutor(@ApiParam("Identifier of the tutor") @PathVariable(name = "id") Long id) {
        if (id == null || tutorService.getTutor(id) == null) {
            log.warn("Tutor not found by id in the database");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Offer> offers = tutorService.getOffersByTutor(id, username);
        if (offers == null) {
            log.warn("User does not have permission to get the offers of the tutor.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Offers retrieved successfully");
        return ResponseEntity.ok(OfferDTO.fromOffers(offers));
    }

}
