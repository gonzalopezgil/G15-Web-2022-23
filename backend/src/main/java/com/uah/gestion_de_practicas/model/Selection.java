package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

import com.uah.gestion_de_practicas.repository.DAO.SelectionIdentity;

/**
 * Selection class, represents a selection of internship offers made by a student in the database.
 */
@Entity
@Table(name = "oferta_seleccionada")
public class Selection {

    @EmbeddedId
    private SelectionIdentity selectionIdentity;
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
    public Selection(SelectionIdentity selectionIdentity, Integer preference) {
        this.selectionIdentity = selectionIdentity;
        this.preference = preference;
    }

    // -------------------- GETTERS --------------------
    /**
     * Get the selection identity object that contains the primary key of the selection class.
     * @return the selection identity object that contains the primary key of the selection class.
     */
    public SelectionIdentity getSelectionIdentity() {
        return selectionIdentity;
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
     * Set the selection identity object that contains the primary key of the selection class.
     * @param selectionIdentity, the selection identity object that contains the primary key of the selection class.
     */
    public void setSelectionIdentity(SelectionIdentity selectionIdentity) {
        this.selectionIdentity = selectionIdentity;
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
                "student_id=" + selectionIdentity.getStudent_id() +
                ", offer_id=" + selectionIdentity.getOffer_id() +
                ", preference=" + preference +
                '}';
    }
    
}
