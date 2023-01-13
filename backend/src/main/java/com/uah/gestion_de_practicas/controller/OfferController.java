package com.uah.gestion_de_practicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.service.OfferService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import com.uah.gestion_de_practicas.controller.dto.OfferDTO;
import com.uah.gestion_de_practicas.model.Offer;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/practices/offers")
public class OfferController {

    /** 
     * Service to manage the offers
     */
    private final OfferService offerService;

    /** 
     * Constructor of the class
     * @param offerService, the service to manage the offers
     */
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    // --------------------- CRUD OPERATIONS --------------------- //
    /** 
     * Endpoint to get all the offers
     * @return a list of offers
     */
    @GetMapping("")
    @ApiOperation("Get all the offers")
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        log.info("List of all the offers obtained successfully");
        return ResponseEntity.ok(OfferDTO.fromOffers(offerService.getAllOffers()));
    }

    /** 
     * Endpoint to create a new offer
     * Only the tutors can create a new offer
     * @param offer, the offer to be created
     * @return the created offer in the body of the response
     */
    @PostMapping("")
    @ApiOperation("Create a new offer")
    public ResponseEntity<OfferDTO> createOffer(@ApiParam("The offer to be saved") @RequestBody OfferDTO offer) {
        if (offer == null || offer.getId() != null || offer.getCompany_id() == null || offer.getStart_date() == null) {
            log.warn("Bad request to create a new offer");
            return ResponseEntity.badRequest().build();
        }
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Offer saved_offer = offerService.saveOffer(OfferDTO.toOffer(offer, offerService.getCompany(offer.getCompany_id())), username);
        if (saved_offer == null) {
            log.warn("The user is not authorized to create this offer");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Offer created successfully");
        return ResponseEntity.ok(OfferDTO.fromOffer(saved_offer));
    }

    /** 
     * Endpoint to get an offer by its id
     * @param id, the id of the offer to be retrieved
     * @return the offer in the body of the response
     */
    @GetMapping("/{id}")
    @ApiOperation("Get an offer by its id")
    public ResponseEntity<OfferDTO> getOffer(@ApiParam("The id of the offer to be retrieved") @PathVariable Long id) {
        if (id == null) {
            log.warn("Bad request to get an offer by its id");
            return ResponseEntity.badRequest().build();
        }
        if (offerService.getOffer(id) == null) {
            log.warn("The offer searched by id does not exist");
            return ResponseEntity.notFound().build();
        }
        log.info("Offer searched by id retrieved successfully");
        return ResponseEntity.ok(OfferDTO.fromOffer(offerService.getOffer(id)));
    }

    /** 
     * Endpoint to update an offer
     * Only the tutor of the offer can modify the information
     * @param id, the id of the offer to be updated
     * @param offer, the offer to be updated
     * @return the updated offer in the body of the response
     */
    @PutMapping("/{id}")
    @ApiOperation("Update an offer")
    public ResponseEntity<OfferDTO> updateOffer(@ApiParam("The id the offer to be updated") @PathVariable Long id, @ApiParam("Offer to be updated") @RequestBody OfferDTO offer) {
        if (id == null || offer == null || offer.getId() != null || !id.equals(offer.getId())
                || offer.getCompany_id() == null || offer.getStart_date() == null) {
            log.warn("Bad request to update an offer");
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Offer saved_offer = offerService.saveOffer(OfferDTO.toOffer(offer, offerService.getCompany(offer.getCompany_id())), username);
        if (saved_offer == null) {
            log.warn("The user is not authorized to update this offer");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Offer updated successfully");
        return ResponseEntity.ok(OfferDTO.fromOffer(saved_offer));
    }

    /**
     * Endpoint to delete an offer
     * Only the tutor of the offer can delete the offer
     * @param id, the id of the offer to be deleted
     */
    @DeleteMapping("/{id}")
    @ApiOperation("Delete an offer")
    public ResponseEntity<Void> deleteOffer(@ApiParam("Id of the offer to be deleted") @PathVariable Long id) {
        if (id == null) {
            log.warn("Bad request to delete an offer");
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!offerService.deleteOffer(id, username)) {
            log.warn("The user is not authorized to delete this offer");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("Offer deleted successfully");
        return ResponseEntity.ok().build();
    }


    
}
