package com.uah.gestion_de_practicas.service;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.controller.dto.OfferSelection;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Request;
import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.repository.StudentRepository;

import java.util.List;

/**
 * Service class for the Student class.
 * Implements the business logic for the Student class.
 */
@Service
public class StudentService {

    /**
     * Data access repository for the Student class.
     */
    private final StudentRepository studentRepository;
    private final RequestService requestService;
    private final OfferService offerService;

    public StudentService(StudentRepository studentRepository, RequestService requestService, OfferService offerService) {
        this.studentRepository = studentRepository;
        this.requestService = requestService;
        this.offerService = offerService;
    }


    // ------------------- CRUD OPERATIONS ------------------- //
    /**
     * Saves a student in the database.
     * @param student Student to be saved.
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Gets a student from the database.
     * @param id Id of the student to be retrieved.
     */
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a student from the database.
     * @param id Id of the student to be deleted.
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * Gets all the students from the database.
     * @return A list with all the students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ------------------- SPECIFIC OPERATIONS ------------------- //
    /**
     * Gets all the students from a company.
     * @param id Id of the company.
     * @return A list with all the students from the company.
     */
    public List<Student> getStudentsFromCompany(Long id) {
        return studentRepository.getStudentsFromCompany(id);
    }

    public List<Student> getAllUnassignedStudents() {
        return studentRepository.getAllUnassignedStudents();
    }

    public List<Student> getElegibleStudents(Long offer_id){
        return studentRepository.getElegibleForOffer(offer_id);
    }

    public List<Request> selectOffers(Long student_id, List<OfferSelection> selections){
        Student student = studentRepository.findById(student_id).orElse(null);
        requestService.deleteRequestsByStudentId(student_id);
        for (OfferSelection selection : selections) {
            Offer offer = offerService.getOffer(selection.getOfferId());
            Request request = new Request(student, offer, selection.getPreference());
            requestService.saveRequest(request);
        }

        return requestService.getRequestsByStudentId(student_id);
    }

    public List<Request> getRequestsByStudentId(Long student_id){
        return requestService.getRequestsByStudentId(student_id);
    }

    public Boolean isAvailableForPractice(Long student_id) {
        return studentRepository.hasActivePractice(student_id).isEmpty();
    }
    
    /** 
     * Get the students of a tutor
     * @param tutor_id Id of the tutor
     * @return A list with all the students of the tutor
     */
    public List<Student> getStudentsFromTutor(Long tutor_id) {
        return studentRepository.getStudentsFromTutor(tutor_id);
    }
}