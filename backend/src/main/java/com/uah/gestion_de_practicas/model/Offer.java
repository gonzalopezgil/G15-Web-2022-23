package com.uah.gestion_de_practicas.model;

import javax.persistence.*;

/**
 * Offer class, represents an internship offer in the database.
 */
@Entity
@Table(name = "oferta")
public class Offer {

    @Column(name = "id")
    private Long id;
    @Column(name = "puesto")
    private String position;
    @Column(name = "categoria")
    private String category;
    @Column(name = "id_empresa")
    private Long company_id;
    @Column(name = "direccion")
    private String address;
    @Column(name = "requisitos")
    private String requirements;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "horario")
    private String schedule;
    @Column(name = "semanas")
    private Integer weeks;
    @Column(name = "sueldo")
    private Double salary;
    @Column(name = "plazas")
    private Integer vacancies;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Offer() {
    }

    /**
     * Constructor for the Offer class.
     * @param position, the job position of the internship offer.
     * @param category, the category of the internship offer.
     * @param company_id, the id of the company that offers the internship.
     * @param address, the address of the company that offers the internship.
     * @param requirements, the requirements of the internship offer.
     * @param description, the description of the internship offer.
     * @param schedule, the schedule of the internship offer.
     * @param weeks, the weeks of the internship offer.
     * @param salary, the salary of the internship offer.
     * @param vacancies, the number of total vacancies of the internship offer.
     */
    public Offer(String position, String category, Long company_id, String address, String requirements,
            String description, String schedule, Integer weeks, Double salary, Integer vacancies) {
        this.position = position;
        this.category = category;
        this.company_id = company_id;
        this.address = address;
        this.requirements = requirements;
        this.description = description;
        this.schedule = schedule;
        this.weeks = weeks;
        this.salary = salary;
        this.vacancies = vacancies;
    }

    // ----------------- GETTERS -----------------
    /**
     * Get the id of the offer, this is the primary key of the offer.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the offer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Get the job position of the internship offer.
     * @return the job position of the internship offer.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Get the category of the internship offer.
     * @return the category of the internship offer.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get the id of the company that offers the internship.
     * @return the id of the company that offers the internship.
     */
    public Long getCompany_id() {
        return company_id;
    }

    /**
     * Get the address of the company that offers the internship.
     * @return the address of the company that offers the internship.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the requirements of the internship offer.
     * @return the requirements of the internship offer.
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Get the description of the internship offer.
     * @return the description of the internship offer.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the schedule of the internship offer.
     * @return the schedule of the internship offer.
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Get the weeks of the internship offer.
     * @return the weeks of the internship offer.
     */
    public Integer getWeeks() {
        return weeks;
    }

    /**
     * Get the salary of the internship offer.
     * @return the salary of the internship offer.
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Get the number of total vacancies of the internship offer.
     * @return the number of total vacancies of the internship offer.
     */
    public Integer getVacancies() {
        return vacancies;
    }

    // ----------------- SETTERS -----------------
    /**
     * Set the id of the offer
     * @param id, the id of the offer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the job position of the internship offer.
     * @param position, the job position of the internship offer.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Set the category of the internship offer.
     * @param category, the category of the internship offer.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Set the id of the company that offers the internship.
     * @param company_id, the id of the company that offers the internship.
     */
    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    /**
     * Set the address of the company that offers the internship.
     * @param address, the address of the company that offers the internship.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the requirements of the internship offer.
     * @param requirements, the requirements of the internship offer.
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Set the description of the internship offer.
     * @param description, the description of the internship offer.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the schedule of the internship offer.
     * @param schedule, the schedule of the internship offer.
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Set the weeks of the internship offer.
     * @param weeks, the weeks of the internship offer.
     */
    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    /**
     * Set the salary of the internship offer.
     * @param salary, the salary of the internship offer.
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Set the number of total vacancies of the internship offer.
     * @param vacancies, the number of total vacancies of the internship offer.
     */
    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    // ----------------- METHODS -----------------
    /**
     * Method to convert the offer object to a string.
     * @return the string representation of the offer object.
     */
    @Override
    public String toString() {
        return "Offer{" + "id=" + id + ", position=" + position + ", category=" + category
                + ", company_id=" + company_id + ", address=" + address + ", requirements=" + requirements
                + ", description=" + description + ", schedule=" + schedule + ", weeks=" + weeks
                + ", salary=" + salary + ", vacancies=" + vacancies + '}';
    }
    
}
