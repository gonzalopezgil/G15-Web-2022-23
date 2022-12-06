package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

/**
 * Selection class, represents a selection of internship offers made by a student in the database.
 */
@Entity
@Table(name = "oferta_seleccionada")
public class Selection {

    @Column(name = "id_alumno")
    private Long student_id;
    @Column(name = "id_oferta")
    private Long offer_id;
    @Column(name = "preferencia")
    private Integer preference;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Selection() {
    }

    /**
     * Constructor for the Selection class.
     * @param student_id, the id of the student that made the selection.
     * @param offer_id, the id of the internship offer selected.
     * @param preference, the preference of the internship offer selected (from 1 to 10).
     */
    public Selection(Long student_id, Long offer_id, Integer preference) {
        this.student_id = student_id;
        this.offer_id = offer_id;
        this.preference = preference;
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

    /**
     * Get the preference of the internship offer selected (from 1 to 10).
     * @return an integer between 1 and 10 representing the preference of the internship offer selected.
     */
    public Integer getPreference() {
        return preference;
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

    /**
     * Set the preference of the internship offer selected (from 1 to 10).
     * @param preference, an integer between 1 and 10 representing the preference of the internship offer selected.
     */
    public void setPreference(Integer preference) {
        this.preference = preference;
    }

    // -------------------- METHODS --------------------
    /**
     * Method to convert the selection object to a String.
     * @return the string representation of the selection object.
     */
    @Override
    public String toString() {
        return "Selection{" +
                "student_id=" + student_id +
                ", offer_id=" + offer_id +
                ", preference=" + preference +
                '}';
    }
    
}
