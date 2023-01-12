package com.uah.gestion_de_practicas.controller.dto;

import lombok.ToString;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;
import java.sql.Date;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.Company;
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

    public static OfferDTO fromOffer(Offer offer) {
        if (offer == null)
            return null;

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

    public static List<OfferDTO> fromOffers(List<Offer> offers) {
        if (offers == null)
            return null;
        return offers.stream().map(OfferDTO::fromOffer).collect(Collectors.toList());
    }

    public static Offer toOffer(OfferDTO offerDTO, Company company) {
        if (offerDTO == null)
            return null;
        Offer offer = new Offer();
        offer.setId(offerDTO.getId());
        offer.setPosition(offerDTO.getPosition());
        offer.setCategory(offerDTO.getCategory());
        offer.setCompany(company);
        offer.setAddress(offerDTO.getAddress());
        offer.setRequirements(offerDTO.getRequirements());
        offer.setDescription(offerDTO.getDescription());
        offer.setSchedule(offerDTO.getSchedule());
        offer.setWeeks(offerDTO.getWeeks());
        offer.setSalary(offerDTO.getSalary());
        offer.setVacancies(offerDTO.getVacancies());
        offer.setStart_date(offerDTO.getStart_date());
        return offer;
    }
}
