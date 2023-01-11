package com.uah.gestion_de_practicas.repository.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SimplePracticeDAO {
    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;
    private Date start_date;
    private Date end_date;

    public SimplePracticeDAO(Practice practice) {
        this.id = practice.getId();
        this.student_id = practice.getStudent().getId();
        this.offer_id = practice.getOffer().getId();
        this.mark = practice.getMark();
        this.report = practice.getReport();
        this.start_date = practice.getStart_date();
        this.end_date = practice.getEnd_date();
    }

    public static SimplePracticeDAO fromPractice(Practice practice) {
        return new SimplePracticeDAO(practice);
    }

    public static List<SimplePracticeDAO> fromPractices(List<Practice> practices) {
        if (practices == null) {
            return null;
        }
        return practices.stream().map(SimplePracticeDAO::fromPractice).collect(Collectors.toList());
    }

}
