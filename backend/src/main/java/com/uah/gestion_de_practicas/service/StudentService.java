package com.uah.gestion_de_practicas.service;

import org.springframework.stereotype.Service;

import com.uah.gestion_de_practicas.controller.dto.OfferSelection;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
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
    private final PracticeService practiceService;

    public StudentService(StudentRepository studentRepository, RequestService requestService, OfferService offerService, PracticeService practiceService) {
        this.studentRepository = studentRepository;
        this.requestService = requestService;
        this.offerService = offerService;
        this.practiceService = practiceService;
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

    /** 
     * Gets all the unassigned students.
     * @return A list with all the unassigned students.
     */
    public List<Student> getAllUnassignedStudents() {
        return studentRepository.getAllUnassignedStudents();
    }

    /** 
     * Gets all the students that are elegible for an offer.
     * @param offer_id Id of the offer.
     * @return A list with all the elegible students.
     */
    public List<Student> getElegibleStudents(Long offer_id){
        return studentRepository.getElegibleForOffer(offer_id);
    }

    /** 
     * Saves the preferences of a student for a list of offers.
     * @param student_id, Id of the student.
     * @param selections, List of offers and preferences.
     * @return A list with all the requests of the student.
     */
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

    /** 
     * Gets all the requests of a student.
     * @param student_id, Id of the student.
     * @return A list with all the requests of the student.
     */
    public List<Request> getRequestsByStudentId(Long student_id){
        return requestService.getRequestsByStudentId(student_id);
    }

    /** 
     * Checks if a student has an active practice.
     * @param student_id, Id of the student.
     * @return True if the student has an active practice, false otherwise.
     */
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

    /** 
     * Get completed practices of a student
     * @param id Id of the student
     * @return A list with all the completed practices of the student
     */
    public List<Practice> getCompletedPractices(Long id) {
        return practiceService.getCompletedPracticesByStudent(id);
    }
}