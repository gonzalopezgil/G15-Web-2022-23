package com.uah.gestion_de_practicas.controller.dto;

import java.util.Date;
import java.util.List;

import com.uah.gestion_de_practicas.model.Supervisor;

import lombok.*;

/**
 * DTO to manage the supervisor data.
 */
@Data
@EqualsAndHashCode
@ToString
public class SupervisorDTO {
    private Long user_id;
    private Date admission_date;
    private Date removal_date;

    public SupervisorDTO(Long user_id, Date admission_date, Date removal_date) {
        this.user_id = user_id;
        this.admission_date = admission_date;
        this.removal_date = removal_date;
    }

    public static SupervisorDTO fromSupervisor(Supervisor supervisor) {
        return new SupervisorDTO(supervisor.getId(), supervisor.getAdmission_date(), supervisor.getRemoval_date());
    }

    public static List<SupervisorDTO> fromSupervisors(List<Supervisor> supervisors) {
        return supervisors.stream().map(SupervisorDTO::fromSupervisor).toList();
    }
}
