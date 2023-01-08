package com.uah.gestion_de_practicas.repository.dao;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class TutorDAO {
    private Long user_id;
    private Long company_id;
    private Date admission_date;
    private Date removal_date;

    public TutorDAO(Long user_id, Long company_id, Date admission_date, Date removal_date) {
        this.user_id = user_id;
        this.company_id = company_id;
        this.admission_date = admission_date;
        this.removal_date = removal_date;
    }

}