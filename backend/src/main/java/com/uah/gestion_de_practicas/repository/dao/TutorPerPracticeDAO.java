package com.uah.gestion_de_practicas.repository.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class TutorPerPracticeDAO {
    private String first_name;
    private String last_name;
    private Long tutor_id;

    public TutorPerPracticeDAO(String first_name, String last_name, Long tutor_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.tutor_id = tutor_id;
    }

    public TutorPerPracticeDAO() {
    }

    public String getCompleteName() {
        return first_name + " " + last_name;
    }
    
}
