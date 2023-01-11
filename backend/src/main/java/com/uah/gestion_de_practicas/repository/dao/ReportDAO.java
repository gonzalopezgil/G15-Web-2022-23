package com.uah.gestion_de_practicas.repository.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.controller.dto.ReportDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DAO to receive the report object in the company service.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReportDAO {
    private Long id;
    private Long student_id;
    private Long offer_id;
    private Double mark;
    private String report;

    public static ReportDAO fromDTO(ReportDTO reportDTO) {
        return new ReportDAO(reportDTO.getId(), reportDTO.getStudent_id(), reportDTO.getOffer_id(), reportDTO.getMark(),
                reportDTO.getReport());
    }
    
    public static List<ReportDAO> fromDTO(List<ReportDTO> reportDTOList) {
        if (reportDTOList == null) {
            return null;
        }
        return reportDTOList.stream().map(reportDTO -> ReportDAO.fromDTO(reportDTO)).collect(Collectors.toList());
    }
    
}
