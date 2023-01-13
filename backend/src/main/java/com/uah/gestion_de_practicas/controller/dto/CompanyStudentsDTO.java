package com.uah.gestion_de_practicas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.repository.dao.CompanyStudentsDAO;

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
public class CompanyStudentsDTO {

    private Long id;
    private String name;
    private String description;
    private Long students;
    
    public static CompanyStudentsDTO fromDAO(CompanyStudentsDAO company_students_dao) {
        return new CompanyStudentsDTO(company_students_dao.getId(), company_students_dao.getName(), company_students_dao.getDescription(), company_students_dao.getStudents());
    }

    public static List<CompanyStudentsDTO> fromDAO(List<CompanyStudentsDAO> company_students_dao_list) {
        if (company_students_dao_list == null) {
            return null;
        }
        return company_students_dao_list.stream().map(company_students_dao -> CompanyStudentsDTO.fromDAO(company_students_dao)).collect(Collectors.toList());
    }
}
