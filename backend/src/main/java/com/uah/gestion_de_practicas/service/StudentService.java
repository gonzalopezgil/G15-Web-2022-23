package com.uah.gestion_de_practicas.service;

import org.springframework.stereotype.Service;

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

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
    
}
