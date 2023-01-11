package com.uah.gestion_de_practicas.controller.dto;

import lombok.ToString;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Offer;

@Data
@EqualsAndHashCode
@ToString
public class OfferDTO {
    private Long id;
    private String position;
    private String category;
    private Long company_id;
    private String address;
    private String requirements;
    private String description;
    private String schedule;
    private Integer weeks;
    private Double salary;
    private Integer vacancies;
    private Date start_date;

    public OfferDTO(Long id, String position, String category, Long company_id, String address, String requirements, String description, String schedule, Integer weeks, Double salary, Integer vacancies, Date start_date) {
        this.id = id;
        this.position = position;
        this.category = category;
        this.company_id = company_id;
        this.address = address;
        this.requirements = requirements;
        this.description = description;
        this.schedule = schedule;
        this.weeks = weeks;
        this.salary = salary;
        this.vacancies = vacancies;
        this.start_date = start_date;
    }

    public OfferDTO() {
    }

    public static OfferDTO fromOffer(Offer offer){
        return new OfferDTO(
                offer.getId(),
                offer.getPosition(),
                offer.getCategory(),
                offer.getCompany().getId(),
                offer.getAddress(),
                offer.getRequirements(),
                offer.getDescription(),
                offer.getSchedule(),
                offer.getWeeks(),
                offer.getSalary(),
                offer.getVacancies(),
                offer.getStart_date()
        );
    }

    public static List<OfferDTO> fromOffers(List<Offer> offers){
        return offers.stream().map(OfferDTO::fromOffer).collect(Collectors.toList());
    }
}
