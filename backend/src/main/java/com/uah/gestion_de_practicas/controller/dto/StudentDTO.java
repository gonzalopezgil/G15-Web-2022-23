package com.uah.gestion_de_practicas.controller.dto;

import com.uah.gestion_de_practicas.model.Student;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
/**
 * DTO for returning a student without sensitive information
 */
public class StudentDTO {

    private Long id;
    private String username;
    private String first_name;
    private String last_name;
    private String nif;
    private String email;
    private String degree;
    private Integer total_hours;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.username = student.getUsername();
        this.first_name = student.getFirstName();
        this.last_name = student.getLastName();
        this.nif = student.getNif();
        this.email = student.getEmail();
        this.degree = student.getDegree();
        this.total_hours = student.getTotal_hours();
    }
    
}