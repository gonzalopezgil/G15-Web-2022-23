package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Tutor class, represents a tutor in the database.
 */
@Entity
@Table(name = "tutor")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Tutor extends User {

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
    private Company company;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Tutor() {
    }

    /**
     * Constructor for the Tutor class.
     * @param username, the username of the tutor.
     * @param password, the password of the tutor.
     * @param first_name, the first name of the tutor.
     * @param last_name, the last name of the tutor.
     * @param nif, the NIF of the tutor.
     * @param email, the email of the tutor.
     * @param admission_date, the admission date of the tutor.
     * @param removal_date, the removal date of the tutor.
     * @param company_id, the id of the company of the tutor.
     */
    public Tutor(String username, String password, String first_name, String last_name, String nif, String email,
            Date admission_date, Date removal_date, Company company) {
        super(username, password, first_name, last_name, nif, email);
        this.admission_date = admission_date;
        this.removal_date = removal_date;
        this.company = company;
    }

    // ----------------- GETTERS -----------------
    /**
     * Get the id of the tutor, this is the primary key of the tutor.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the tutor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(targetEntity = User.class, cascade = CascadeType.REMOVE, mappedBy = "id_usuario")
    public Long getId() {
        return id;
    }

    /**
     * Get the admission date of the tutor.
     * @return the admission date of the tutor.
     */
    @Column(name = "f_alta")
    public Date getAdmission_date() {
        return admission_date;
    }

    /**
     * Get the removal date of the tutor.
     * @return the removal date of the tutor.
     */
    @Column(name = "f_baja")
    public Date getRemoval_date() {
        return removal_date;
    }

    /**
     * Get the id of the company of the tutor.
     * @return the id of the company of the tutor.
     */
    @JoinColumn(name = "id_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    public Company getCompany() {
        return company;
    }

    // ----------------- SETTERS -----------------
    /**
     * Set the id of the tutor.
     * @param id, the id of the tutor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the admission date of the tutor.
     * @param admission_date, the admission date of the tutor.
     */
    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    /**
     * Set the removal date of the tutor.
     * @param removal_date, the removal date of the tutor.
     */
    public void setRemoval_date(Date removal_date) {
        this.removal_date = removal_date;
    }

    /**
     * Set the id of the company of the tutor.
     * @param company_id the new company id of the tutor.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    // ----------------- METHODS -----------------
    /**
     * Method to print the tutor.
     * @return the string representation of the tutor.
     */
    @Override
    public String toString() {
        return "Tutor {id=" + id + ", admission_date=" + admission_date + ", removal_date=" + removal_date + ", company_id=" + company.getId() + "}";
    }
    
}
