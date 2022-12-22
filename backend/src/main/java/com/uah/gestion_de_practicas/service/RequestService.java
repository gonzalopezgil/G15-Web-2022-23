package com.uah.gestion_de_practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Request;
import com.uah.gestion_de_practicas.repository.RequestRepository;

/**
 * Service class for the Request class.
 * Implements the business logic for the Request class.
 */
@Service
public class RequestService {

    /**
     * Data access repository for the Request class.
     */
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // ------------------- CRUD OPERATIONS ------------------- //

    /**
     * Saves a request in the database.
     * @param request Request to be saved.
     */
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    /**
     * Gets a request from the database.
     * @param id Id of the request to be retrieved.
     */
    public Request getRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a request from the database.
     * @param id Id of the request to be deleted.
     */
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

    /**
     * Gets all the requests from the database.
     * @return A list with all the requests.
     */
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
    
}
