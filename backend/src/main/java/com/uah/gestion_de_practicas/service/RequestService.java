package com.uah.gestion_de_practicas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Request;
import com.uah.gestion_de_practicas.model.Student;
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

    /** 
     * Constructor for the RequestService class.
     */
    public RequestService(RequestRepository requestRepository, OfferService offerService) {
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
     * Assign practice offers to students.
     * @return List of practices created.
     */
    public List<Practice> getPracticeAssignments() {
        // Assign practices to students with the greater exp_grade and no practice assigned.
        List<Request> requests = requestRepository.findAll();
        List<Practice> new_practices = new ArrayList<Practice>();
        
        //For each offer, get the student with the greatest exp_grade and assign the offer to him.
        for (Request request : requests){
            Offer offer = request.getOffer();
            if (offer.getVacancies() > 0){
                List<Student> elegibleStudents = requestRepository.getStudentsByOfferId(offer.getId());
                while (elegibleStudents.size() > 0){
                    Student student = elegibleStudents.get(0);
                    Practice practice = new Practice();
                    practice.setStudent(student);
                    practice.setOffer(offer);
                    practice.setStart_date(offer.getStart_date());
                    
                    // Remove the student from the list of elegible students.
                    elegibleStudents.remove(0);
                    requestRepository.deleteByStudentId(student.getId());

                    // Update the number of vacancies of the offer and save the practice.
                    offer.setVacancies(offer.getVacancies() - 1);
                    new_practices.add(practice);
                }
            }
        }
        return new_practices;
    }

    /**
     * Deletes a request from the database.
     * @param id Id of the request to be deleted.
     */
    public void deleteRequest(Long id) {
        if (requestRepository.findById(id).isPresent())
            requestRepository.deleteById(id);
    }

    /**
     * Gets all the requests from the database.
     * @return A list with all the requests.
     */
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
 
    /** 
     * Gets all the requests from the database for a given student.
     * @param studentId, Id of the student.
     * @return A list with all the requests for the given student.
     */
    public List<Request> getRequestsByStudentId(Long studentId) {
        return requestRepository.findAllByStudentId(studentId);
    }

    /** 
     * Deletes all the requests from the database for a given student.
     * @param student_id, Id of the student.
     */
    public void deleteRequestsByStudentId(Long student_id) {
        requestRepository.deleteByStudentId(student_id);
    }

}
