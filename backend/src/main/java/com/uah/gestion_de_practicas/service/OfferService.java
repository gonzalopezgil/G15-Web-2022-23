package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Company;
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

    /** 
     * Service object for the Tutor class
     */
    private final TutorService tutorService;

    /** 
     * Service object for the Company class
     */
    private final CompanyService companyService;

    public OfferService(OfferRepository offerRepository, TutorService tutorService, @Lazy CompanyService companyService) {
        this.offerRepository = offerRepository;
        this.tutorService = tutorService;
        this.companyService = companyService;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves an offer in the database.
     */
    public Offer saveOffer(Offer offer, String tutor_username) {
        if (!tutorService.isAuthorized(tutor_username, offer.getCompany().getId())) {
            return null;
        }
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
     * @param tutor_username Username of the tutor that wants to delete the offer.
     * @return The boolean value true if the offer was deleted, false otherwise.
     */
    public boolean deleteOffer(Long id, String tutor_username) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if (offer == null || !tutorService.isAuthorized(tutor_username, offer.getCompany().getId())) {
            return false;
        }
        offerRepository.deleteById(id);
        return true;
    }

    /**
     * Gets all the offers from the database.
     * @return A list with all the offers.
     */
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
    

    // ------------------- OTHER METHODS ------------------- //
    
    /** 
     * Get the company of an offer
     * @param id, the id of the company
     * @return the company of the offer
     */
    public Company getCompany(Long id) {
        return companyService.getCompany(id);
    }
}
