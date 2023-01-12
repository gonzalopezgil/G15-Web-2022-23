package com.uah.gestion_de_practicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.controller.dto.OfferDTO;
import com.uah.gestion_de_practicas.model.Offer;

import java.util.List;

@RestController
@RequestMapping("/api/practices/offers")
public class OfferController {

    
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    // --------------------- CRUD OPERATIONS --------------------- //
    /** 
     * Endpoint to get all the offers
     * @return a list of offers
     */
    @GetMapping("")
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        return ResponseEntity.ok(OfferDTO.fromOffers(offerService.getAllOffers()));
    }

    /** 
     * Endpoint to create a new offer
     * Only the tutors can create a new offer
     * @param offer, the offer to be created
     * @return the created offer in the body of the response
     */
    @PostMapping("")
    public ResponseEntity<OfferDTO> createOffer(OfferDTO offer) {
        if (offer == null || offer.getId() != null || offer.getCompany_id() == null || offer.getStart_date() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Offer saved_offer = offerService.saveOffer(OfferDTO.toOffer(offer, offerService.getCompany(offer.getCompany_id())), username);
        if (saved_offer == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(OfferDTO.fromOffer(saved_offer));
    }

    /** 
     * Endpoint to get an offer by its id
     * @param id, the id of the offer to be retrieved
     * @return the offer in the body of the response
     */
    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOffer(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        if (offerService.getOffer(id) == null)
            return ResponseEntity.notFound().build();
        
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
    public ResponseEntity<OfferDTO> updateOffer(@PathVariable Long id, OfferDTO offer) {
        if (id == null || offer == null || offer.getId() != null || !id.equals(offer.getId()) || offer.getCompany_id() == null || offer.getStart_date() == null) {
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Offer saved_offer = offerService.saveOffer(OfferDTO.toOffer(offer, offerService.getCompany(offer.getCompany_id())), username);
        if (saved_offer == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(OfferDTO.fromOffer(saved_offer));
    }

    /**
     * Endpoint to delete an offer
     * Only the tutor of the offer can delete the offer
     * @param id, the id of the offer to be deleted
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!offerService.deleteOffer(id, username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok().build();
    }


    
}
