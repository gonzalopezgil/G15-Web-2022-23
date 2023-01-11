package com.uah.gestion_de_practicas.controller.dto;

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

}
