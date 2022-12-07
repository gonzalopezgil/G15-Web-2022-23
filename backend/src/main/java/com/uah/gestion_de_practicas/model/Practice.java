package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import javax.persistence.*;

/**
 * Practice class, represents a student's practice in the database.
 */
// @Entity
// @Table(name = "practica")
public class Practice {

    @Column(name = "id_practica")
    private Long id;
    @Column(name = "id_alumno")
    private Long student_id;
    @Column(name = "id_oferta")
    private Long offer_id;
    @Column(name = "nota")
    private Double mark;
    @Column(name = "informe")
    private String report;
    @Column(name = "f_inicio")
    private Date start_date;
    @Column(name = "f_fin")
    private Date end_date;

    /**
     * Empty constructor needed for Hibernate.
     */
    public Practice() {
    }

    /**
     * Constructor for the Practice class.
     * @param student_id, the id of the student.
     * @param offer_id, the id of the offer.
     * @param mark, the student's mark in the practice.
     * @param report, the tutor's comments on the student in the practice.
     * @param start_date, the start date of the practice.
     * @param end_date, the end date of the practice.
     */
    public Practice(Long student_id, Long offer_id, Double mark, String report, Date start_date, Date end_date) {
        this.student_id = student_id;
        this.offer_id = offer_id;
        this.mark = mark;
        this.report = report;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    // ----------------- GETTERS -----------------
    /**
     * Get the id of the practice, this is the primary key of the practice.
     * Whose id is auto-generated in the database by the Identity strategy.
     * @return the id of the practice.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Get the id of the student.
     * @return the id of the student.
     */
    public Long getStudent_id() {
        return student_id;
    }

    /**
     * Get the id of the offer.
     * @return the id of the offer.
     */
    public Long getOffer_id() {
        return offer_id;
    }

    /**
     * Get the mark of the student in the practice.
     * @return the mark of the student in the practice.
     */
    public Double getMark() {
        return mark;
    }

    /**
     * Get the tutor's comments on the student in the practice.
     * @return the report of the practice.
     */
    public String getReport() {
        return report;
    }

    /**
     * Get the start date of the practice.
     * @return the start date of the practice.
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * Get the end date of the practice.
     * @return the end date of the practice.
     */
    public Date getEnd_date() {
        return end_date;
    }

    // ----------------- SETTERS -----------------
    /**
     * Set the id of the practice.
     * @param id, the id of the practice.
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
     * Set the mark of the student in the practice.
     * @param mark, the mark of the student in the practice.
     */
    public void setMark(Double mark) {
        this.mark = mark;
    }

    /**
     * Set the tutor's comments on the student in the practice.
     * @param report, the report of the practice.
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * Set the start date of the practice.
     * @param start_date, the start date of the practice.
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * Set the end date of the practice.
     * @param end_date, the end date of the practice.
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    // ----------------- METHODS -----------------
    /**
     * Method to convert the practice object to a string.
     * @return the string representation of the practice object.
     */
    @Override
    public String toString() {
        return "Practice{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", offer_id=" + offer_id +
                ", mark=" + mark +
                ", report=" + report +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }

}
