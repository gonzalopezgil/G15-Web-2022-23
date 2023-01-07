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
    private final StudentService studentService;
    private final OfferService offerService;


    public RequestService(RequestRepository requestRepository, StudentService studentService, OfferService offerService) {
        this.requestRepository = requestRepository;
        this.studentService = studentService;
        this.offerService = offerService;
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
        
        // For each offer, get the student with the greatest exp_grade and assign the offer to him.
        // for (Request request : requests){
        //     Offer offer = offerService.getOffer(request.getOffer_id());
        //     if (offer.getVacancies() > 0){
        //         List<Student> elegibleStudents = studentService.getElegibleStudents(offer.getId());
        //         while (elegibleStudents.size() > 0){
        //             Student student = elegibleStudents.get(0);
        //             Practice practice = new Practice();
        //             practice.setStudent(student.getId());
        //             practice.setOffer_id(offer.getId());
        //             practice.setStart_date(offer.getStart_date());
                    
        //             // Remove the student from the list of elegible students.
        //             elegibleStudents.remove(0);
        //             requestRepository.deleteByStudentId(student.getId());

        //             // Update the number of vacancies of the offer and save the practice.
        //             offer.setVacancies(offer.getVacancies() - 1);
        //             new_practices.add(practice);
        //         }
        //         offerService.saveOffer(offer);
        //     }
        // }
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
    
}
