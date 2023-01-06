package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Company class, represents a company in the database.
 */
@Entity
@Table(name = "empresa")
@EqualsAndHashCode
public class Company {

    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "sufijo_correo")
    private String mail_suffix;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "direccion")
    private String address;
    @Column(name = "ciudad")
    private String city;
    @Column(name = "codigo_postal") 
    private int postal_code;
    @Column(name = "descripcion")
    private String description;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Company() {
    }

    /**
     * Constructor for the Company class.
     * @param name, the name of the company.
     * @param description, the description of the company.
     */
    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ------------------- GETTERS -------------------
    /**
     * Get the id of the company, this is the primary key of the company.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the company.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Get the name of the company.
     * @return the name of the company.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the company.
     * @return the description of the company.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the email suffix of the company.
     * @return the email suffix of the company.
     */
    public String getMail_suffix() {
        return mail_suffix;
    }

    /**
     * Get the phone number of the company.
     * @return the phone number of the company.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the address of the company.
     * @return the address of the company.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the city of the company.
     * @return the city of the company.
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the postal code of the company.
     * @return the postal code of the company.
     */
    public int getPostal_code() {
        return postal_code;
    }

    // ------------------- SETTERS -------------------
    /**
     * Set the id of the company.
     * @param id, the id of the company.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the name of the company.
     * @param name, the name of the company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description of the company.
     * @param description, the description of the company.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set a new email suffix for the company.
     * @param mail_suffix, the new email suffix for the company.
     */
    public void setMail_suffix(String mail_suffix) {
        this.mail_suffix = mail_suffix;
    }

    /**
     * Set a new phone number for the company.
     * @param phone, the new phone number for the company.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set a new address for the company.
     * @param address, the new address for the company.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set a new city for the company.
     * @param city, the new city for the company.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set a new postal code for the company.
     * @param postal_code, the new postal code for the company.
     */
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    // ------------------- METHODS -------------------
    /**
     * Method to convert the company object to a string.
     * @return the string representation of the company object.
     */
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
    
}
