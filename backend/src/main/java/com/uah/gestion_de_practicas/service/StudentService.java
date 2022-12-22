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
    
}
