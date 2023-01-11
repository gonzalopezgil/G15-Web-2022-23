package com.uah.gestion_de_practicas.repository.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class SimplePracticeDAO {
    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;
    private Date start_date;
    private Date end_date;
}
