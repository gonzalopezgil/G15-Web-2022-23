package com.uah.gestion_de_practicas.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Practice;

/**
 * DTO for returning practice assignations without sensitive information
 */
@Data
@EqualsAndHashCode
@ToString
public class PracticeAssignmentDTO {
    private Long student_id;
    private Long practice_id;

    public PracticeAssignmentDTO(Long student_id, Long practice_id) {
        this.student_id = student_id;
        this.practice_id = practice_id;
    }

    public static PracticeAssignmentDTO fromPractice(Practice practice) {
        return new PracticeAssignmentDTO(practice.getStudent().getId(), practice.getId());
    }
    
    public static List<PracticeAssignmentDTO> fromPractices(List<Practice> practices) {
        return practices.stream().map(PracticeAssignmentDTO::fromPractice).collect(Collectors.toList());
    }
}
