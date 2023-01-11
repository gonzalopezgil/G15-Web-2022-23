package com.uah.gestion_de_practicas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PracticeDTO {

    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;

    public PracticeDTO(Practice practice) {
        this.id = practice.getId();
        this.student_id = practice.getStudent().getId();
        this.offer_id = practice.getOffer().getId();
        this.mark = practice.getMark();
        this.report = practice.getReport();
    }

    public static PracticeDTO fromPractice(Practice practice) {
        return new PracticeDTO(practice);
    }

    public static List<PracticeDTO> fromPractices(List<Practice> practices) {
        if (practices == null) {
            return null;
        }
        return practices.stream().map(PracticeDTO::fromPractice).collect(Collectors.toList());
    }

}
