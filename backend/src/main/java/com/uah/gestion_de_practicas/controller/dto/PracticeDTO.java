package com.uah.gestion_de_practicas.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Practice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PracticeDTO {
    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;
    private Date start_date;
    private Date end_date;

    public PracticeDTO(Long id, Long student_id, Long offer_id, Double mark, String report, Date start_date, Date end_date) {
        this.id = id;
        this.student_id = student_id;
        this.offer_id = offer_id;
        this.mark = mark;
        this.report = report;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public PracticeDTO() {
    }

    public static PracticeDTO fromPractice(Practice practice){
        return new PracticeDTO(
                practice.getId(),
                practice.getStudent().getId(),
                practice.getOffer().getId(),
                practice.getMark(),
                practice.getReport(),
                practice.getStart_date(),
                practice.getEnd_date()
        );   
    }

    public static List<PracticeDTO> fromPractices(List<Practice> practices){
        return practices.stream().map(PracticeDTO::fromPractice).collect(Collectors.toList());
    }
}
