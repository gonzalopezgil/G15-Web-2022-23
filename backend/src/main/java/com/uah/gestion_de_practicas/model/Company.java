package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

/**
 * Company class, represents a company in the database.
 */
@Entity(name = "empresa")
public class Company {

    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String name;
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
