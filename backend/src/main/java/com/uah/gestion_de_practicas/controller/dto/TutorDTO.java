package com.uah.gestion_de_practicas.controller.dto;

import java.sql.Date;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Tutor;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class TutorDTO {
    private Long user_id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String nif;
    private String email;
    private Long company_id;
    private Date admission_date;
    private Date removal_date;

    public TutorDTO(Long user_id, String username, String password, String name, String surname, String nif, String email, Long company_id, Date admission_date, Date removal_date) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.email = email;
        this.company_id = company_id;
        this.admission_date = admission_date;
        this.removal_date = removal_date;
    }

    public Tutor toTutor() {
        Company company = new Company();
        company.setId(company_id);
        return new Tutor(username, password, name, surname, nif, email, admission_date, removal_date, company);
    }
}
