package com.uah.gestion_de_practicas.controller;

import org.springframework.http.ResponseEntity;
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
    @GetMapping("")
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        return ResponseEntity.ok(OfferDTO.fromOffers(offerService.getAllOffers()));
    }

    @PostMapping("")
    public ResponseEntity<OfferDTO> createOffer(Offer offer) {
        return ResponseEntity.ok(OfferDTO.fromOffer(offerService.saveOffer(offer)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOffer(@PathVariable Long id) {
        if (offerService.getOffer(id) == null)
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(OfferDTO.fromOffer(offerService.getOffer(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDTO> updateOffer(@PathVariable Long id, Offer offer) {
        return ResponseEntity.ok(OfferDTO.fromOffer(offerService.saveOffer(offer)));
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
    }


    
}
