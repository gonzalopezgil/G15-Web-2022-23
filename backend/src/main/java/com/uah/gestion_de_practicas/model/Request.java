package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Request class, represents a request of a student to an offer in the database.
 */
@Entity
@Table(name = "solicitud_practicas")
@EqualsAndHashCode
public class Request {

    private Long id;
    private Long student_id;
    private Long offer_id;
    private Integer preference;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Request() {
    }

    /**
     * Constructor for the Request class.
     * @param student_id, the id of the student.
     * @param offer_id, the id of the offer.
     * @param preference, the preference of the student for the offer.
     */
    public Request(Long student_id, Long offer_id, Integer preference) {
        this.student_id = student_id;
        this.offer_id = offer_id;
        this.preference = preference;
    }

    // ----------------- GETTERS -----------------
    /**
     * Get the id of the request, this is the primary key of the request.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the request.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    /**
     * Get the id of the student.
     * @return the id of the student.
     */
    @Column(name = "id_alumno")
    public Long getStudent_id() {
        return student_id;
    }

    /**
     * Get the id of the offer.
     * @return the id of the offer.
     */
    @Column(name = "id_oferta")
    public Long getOffer_id() {
        return offer_id;
    }

    /**
     * Get the preference of the student for the offer.
     * @return the preference of the student for the offer.
     */
    @Column(name = "preferencia")
    public Integer getPreference() {
        return preference;
    }

    // ----------------- SETTERS -----------------

    /**
     * Set the id of the request.
     * @param id, the id of the request.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the id of the student.
     * @param student_id, the id of the student.
     */
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    /**
     * Set the id of the offer.
     * @param offer_id, the id of the offer.
     */
    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    /**
     * Set the preference of the student for the offer.
     * @param preference, the preference of the student for the offer.
     */
    public void setPreference(Integer preference) {
        this.preference = preference;
    }

    // ----------------- METHODS -----------------

    /**
     * Method to print the Request object.
     * @return a String with the Request object's attributes.
     */
    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", offer_id=" + offer_id +
                ", preference=" + preference +
                '}';
    }
    
}
