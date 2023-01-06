package com.uah.gestion_de_practicas.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO for returning the company with the number of students that are doing practices in it
 */
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class CompanyStudentsDAO {

    private Long id;
    private String name;
    private String description;
    private Long students;
    
}
