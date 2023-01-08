package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Offer class, represents an internship offer in the database.
 */
@Entity
@Table(name = "oferta")
@EqualsAndHashCode
public class Offer {

    private Long id;
    private String position;
    private String category;
    private Company company;
    private String address;
    private String requirements;
    private String description;
    private String schedule;
    private Integer weeks;
    private Double salary;
    private Integer vacancies;
    private Date start_date;

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
            String description, String schedule, Integer weeks, Double salary, Integer vacancies, Company company) {
        this.position = position;
        this.category = category;
        this.address = address;
        this.requirements = requirements;
        this.company = company;
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
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    /**
     * Get the job position of the internship offer.
     * @return the job position of the internship offer.
     */
    @Column(name = "puesto")
    public String getPosition() {
        return position;
    }

    /**
     * Get the category of the internship offer.
     * @return the category of the internship offer.
     */
    @Column(name = "categoria")
    public String getCategory() {
        return category;
    }

    /**
     * Get the id of the company that offers the internship.
     * @return the id of the company that offers the internship.
     */
    @JoinColumn(name = "id_empresa")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    public Company getCompany() {
        return company;
    }

    /**
     * Get the address of the company that offers the internship.
     * @return the address of the company that offers the internship.
     */
    @Column(name = "direccion")
    public String getAddress() {
        return address;
    }

    /**
     * Get the requirements of the internship offer.
     * @return the requirements of the internship offer.
     */
    @Column(name = "requisitos")
    public String getRequirements() {
        return requirements;
    }

    /**
     * Get the description of the internship offer.
     * @return the description of the internship offer.
     */
    @Column(name = "descripcion")
    public String getDescription() {
        return description;
    }

    /**
     * Get the schedule of the internship offer.
     * @return the schedule of the internship offer.
     */
    @Column(name = "horario")
    public String getSchedule() {
        return schedule;
    }

    /**
     * Get the weeks of the internship offer.
     * @return the weeks of the internship offer.
     */
    @Column(name = "semanas")
    public Integer getWeeks() {
        return weeks;
    }

    /**
     * Get the salary of the internship offer.
     * @return the salary of the internship offer.
     */
    @Column(name = "sueldo")
    public Double getSalary() {
        return salary;
    }

    /**
     * Get the number of total vacancies of the internship offer.
     * @return the number of total vacancies of the internship offer.
     */
    @Column(name = "plazas")
    public Integer getVacancies() {
        return vacancies;
    }

    /**
     * Get the start date of the internship offer.
     * @return the start date of the internship offer.
     */
    @Column(name = "f_inicio")
    public Date getStart_date() {
        return start_date;
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
    public void setCompany(Company new_company) {
        this.company = new_company;
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

    /**
     * Set the start date of the internship offer.
     * @param start_date, the start date of the internship offer.
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    // ----------------- METHODS -----------------
    /**
     * Method to convert the offer object to a string.
     * @return the string representation of the offer object.
     */
    @Override
    public String toString() {
        return "Offer{" + "id=" + id + ", position=" + position + ", category=" + category
                + ", company_id=" + company + ", address=" + address + ", requirements=" + requirements
                + ", description=" + description + ", schedule=" + schedule + ", weeks=" + weeks
                + ", salary=" + salary + ", vacancies=" + vacancies + ", start_date=" + start_date + '}';
    }
    
}
