package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.repository.OfferRepository;

/**
 * Service class for the Offer class.
 * Implements the business logic for the Offer class.
 */
@Service
public class OfferService {

    /**
     * Data access repository for the Offer class.
     */
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves an offer in the database.
     */
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    /**
     * Gets an offer from the database.
     * @param id Id of the offer to be retrieved.
     */
    public Offer getOffer(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    /**
     * Deletes an offer from the database.
     * @param id Id of the offer to be deleted.
     */
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    /**
     * Gets all the offers from the database.
     * @return A list with all the offers.
     */
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
    

    // ------------------- OTHER METHODS ------------------- //
    
}
