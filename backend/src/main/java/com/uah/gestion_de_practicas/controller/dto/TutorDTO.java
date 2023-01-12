package com.uah.gestion_de_practicas.controller.dto;

import java.sql.Date;

import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Tutor;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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

    public Tutor toTutor() {
        Company company = new Company();
        company.setId(company_id);
        return new Tutor(username, password, name, surname, nif, email, admission_date, removal_date, company);
    }

    public static Tutor toTutor(TutorDTO tutor) {
        Company company = new Company();
        company.setId(tutor.getCompany_id());
        return new Tutor(tutor.getUsername(), tutor.getPassword(), tutor.getName(), tutor.getSurname(), tutor.getNif(), tutor.getEmail(), tutor.getAdmission_date(), tutor.getRemoval_date(), company);
    }
}
