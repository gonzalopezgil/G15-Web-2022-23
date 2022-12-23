package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;

/**
 * Student class, represents a student in the database.
 */
@Entity
@Table(name = "alumno")
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @Column(name = "id_alumno")
    private Long id;
    @Column(name = "grado")
    private String degree;
    @Column(name = "f_nacimiento")
    private Date birth_date;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "nota_exp")
    private Double exp_note;
    @Column(name = "horas_totales")
    private Integer total_hours;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Student() {
    }

    /**
     * Constructor for the Student class.
     * @param username, the username of the student.
     * @param password, the password of the student.
     * @param first_name, the first name of the student.
     * @param last_name, the last name of the student.
     * @param nif, the NIF of the student.
     * @param email, the email of the student.
     * @param degree, the degree of the student.
     * @param birth_date, the birth date of the student.
     * @param phone, the phone of the student.
     * @param exp_note, the average grade of the student.
     * @param total_hours, the total hours of practice corresponding to the student.
     */
    public Student(String username, String password, String first_name, String last_name, String nif, String email,
            String degree, Date birth_date, String phone, Double exp_note, Integer total_hours) {
        super(username, password, first_name, last_name, nif, email);
        this.degree = degree;
        this.birth_date = birth_date;
        this.phone = phone;
        this.exp_note = exp_note;
        this.total_hours = total_hours;
    }
    
    // ----------------- GETTERS -----------------
    /**
     * Get the id of the student, this is the primary key of the student.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the student.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Get the degree of the student.
     * @return the degree of the student.
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Get the birth date of the student.
     * @return the birth date of the student.
     */
    public Date getBirth_date() {
        return birth_date;
    }

    /**
     * Get the phone of the student.
     * @return the phone of the student.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the average grade of the student.
     * @return the average grade of the student.
     */
    public Double getExp_note() {
        return exp_note;
    }

    /**
     * Get the total hours of practice corresponding to the student.
     * @return the total hours of practice corresponding to the student.
     */
    public Integer getTotal_hours() {
        return total_hours;
    }
    
    // ----------------- SETTERS -----------------
    /**
     * Set the id of the student.
     * @param id, the id of the student.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the degree of the student.
     * @param degree, the degree of the student.
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * Set the birth date of the student.
     * @param birth_date, the birth date of the student.
     */
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * Set the phone of the student.
     * @param phone, the phone of the student.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the average grade of the student.
     * @param exp_note, the average grade of the student.
     */
    public void setExp_note(Double exp_note) {
        this.exp_note = exp_note;
    }

    /**
     * Set the total hours of practice corresponding to the student.
     * @param total_hours, the total hours of practice corresponding to the student.
     */
    public void setTotal_hours(Integer total_hours) {
        this.total_hours = total_hours;
    }

    // ----------------- TO STRING -----------------
    /**
     * Returns a string representation of the student.
     * @return student to string.
     */
    @Override
    public String toString() {
        return "Student {id=" + id + ", degree=" + degree + ", birth_date=" + birth_date + ", phone=" + phone + ", exp_note=" + exp_note
                + ", total_hours=" + total_hours + "}";
    }
}
