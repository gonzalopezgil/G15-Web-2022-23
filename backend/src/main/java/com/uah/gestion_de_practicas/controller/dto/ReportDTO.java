package com.uah.gestion_de_practicas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO to receive the report object in the company controller.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReportDTO {
    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;
}
