package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Supervisor class, represents a supervisor in the database.
 */
@Entity
@Table(name = "responsable")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Supervisor extends User {

    @Transient
    private String username;
    @Transient
    private String password;
    @Transient
    private String first_name;
    @Transient
    private String last_name;
    @Transient
    private String nif;
    @Transient
    private String email;

    private Long id;
    private Date admission_date;
    private Date removal_date;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Supervisor() {
    }

    /**
     * Constructor for the Supervisor class.
     * @param username, the username of the supervisor.
     * @param password, the password of the supervisor.
     * @param first_name, the first name of the supervisor.
     * @param last_name, the last name of the supervisor.
     * @param nif, the NIF of the supervisor.
     * @param email, the email of the supervisor.
     * @param admission_date, the admission date of the supervisor.
     * @param removal_date, the removal date of the supervisor, null if is active.
     */
    public Supervisor(String username, String password, String first_name, String last_name, String nif, String email,
            Date admission_date, Date removal_date) {
        super(username, password, first_name, last_name, nif, email);
        this.admission_date = admission_date;
        this.removal_date = removal_date;
    }

    // ----------------- GETTERS -----------------

    /**
     * Get the id of the supervisor, this is the primary key of the supervisor.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the supervisor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(targetEntity = User.class, cascade = CascadeType.REMOVE, mappedBy = "id_usuario")
    public Long getId() {
        return id;
    }

    /**
     * Get the admission date of the supervisor.
     * @return the admission date of the supervisor.
     */
    @Column(name = "f_alta")
    public Date getAdmission_date() {
        return admission_date;
    }

    /**
     * Get the removal date of the supervisor.
     * @return the removal date of the supervisor.
     */
    @Column(name = "f_baja")
    public Date getRemoval_date() {
        return removal_date;
    }

    // ----------------- SETTERS -----------------

    /**
     * Set the id of the supervisor.
     * @param id, the id of the supervisor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the admission date of the supervisor.
     * @param admission_date, the admission date of the supervisor.
     */
    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    /**
     * Set the removal date of the supervisor.
     * @param removal_date, the removal date of the supervisor.
     */
    public void setRemoval_date(Date removal_date) {
        this.removal_date = removal_date;
    }

    // ----------------- METHODS -----------------

    /**
     * Method to print the supervisor.
     * @return the string representation of the supervisor.
     */
    @Override
    public String toString() {
        return "Supervisor {id=" + id + ", admission_date=" + admission_date + ", removal_date=" + removal_date + "}";
    }
    
}
