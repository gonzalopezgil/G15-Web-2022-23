package com.uah.gestion_de_practicas.repository.DAO;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Column;

/**
 * SelectionIdentity class, represents the primary key of the Selection class.
 */
@Embeddable
public class SelectionIdentity implements Serializable {

    @Column(name = "id_alumno")
    private Long student_id;
    @Column(name = "id_oferta")
    private Long offer_id;

    /**
     * Empty constructor needed for Hibernate.
     */
    public SelectionIdentity() {
    }

    /**
     * Constructor for the Selection Identity class.
     * Needed to define the primary key of the Selection class.
     * @param student_id, the id of the student that made the selection.
     * @param offer_id, the id of the internship offer selected.
     */
    public SelectionIdentity(Long student_id, Long offer_id) {
        this.student_id = student_id;
        this.offer_id = offer_id;
    }

    // -------------------- GETTERS --------------------
    /**
     * Get the id of the student that made the selection.
     * @return the id of the student that made the selection.
     */
    public Long getStudent_id() {
        return student_id;
    }

    /**
     * Get the id of the internship offer selected.
     * @return the id of the internship offer selected.
     */
    public Long getOffer_id() {
        return offer_id;
    }

    // -------------------- SETTERS --------------------
    /**
     * Set the id of the student that made the selection.
     * @param student_id, the id of the student that made the selection.
     */
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    /**
     * Set the id of the internship offer selected.
     * @param offer_id, the id of the internship offer selected.
     */
    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

}
