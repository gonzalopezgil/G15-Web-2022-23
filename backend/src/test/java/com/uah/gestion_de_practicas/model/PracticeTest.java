package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PracticeTest")
public class PracticeTest {
    private Practice practice;

    @BeforeEach
    public void setUp() {
        practice = new Practice();
    }

    @Test
    @DisplayName("`getId` should return the id of the practice.")
    public void TestGetId() {
        // Given
        Long id = 1L;
        practice.setId(id);

        // When
        Long result = practice.getId();

        // Then
        Assertions.assertEquals(id, result);
    }

    @Test
    @DisplayName("`getStudentId` should return the id of the student.")
    public void TestGetStudentId() {
        // Given
        Student student = new Student();
        student.setId(1L);
        practice.setStudent(student);

        // When
        Long result = practice.getStudent().getId();

        // Then
        Assertions.assertEquals(student.getId(), result);
    }

    @Test
    @DisplayName("`getOfferId` should return the id of the offer.")
    public void TestGetOfferId() {
        // Given
        Offer offer = new Offer();
        offer.setId(1L);
        practice.setOffer(offer);

        // When
        Long result = practice.getOffer().getId();

        // Then
        Assertions.assertEquals(offer.getId(), result);
    }

    @Test
    @DisplayName("`getMark` should return the student's mark in the practice.")
    public void TestGetMark() {
        // Given
        Double mark = 9.5;
        practice.setMark(mark);

        // When
        Double result = practice.getMark();

        // Then
        Assertions.assertEquals(mark, result);
    }

    @Test
    @DisplayName("`getReport` should return the report of the practice.")
    public void TestGetReport() {
        // Given
        String report = "El alumno ha realizado todas sus tareas correctamente.";
        practice.setReport(report);

        // When
        String result = practice.getReport();

        // Then
        Assertions.assertEquals(report, result);
    }

    @Test
    @DisplayName("`getStartDate` should return the start date of the practice.")
    public void TestGetStartDate() {
        // Given
        Date start_date = Date.valueOf("2020-01-01");
        practice.setStart_date(start_date);

        // When
        Date result = new Date(practice.getStart_date().getTime());

        // Then
        Assertions.assertEquals(start_date, result);
    }

    @Test
    @DisplayName("`getEndDate` should return the end date of the practice.")
    public void TestGetEndDate() {
        // Given
        Date end_date = Date.valueOf("2020-01-01");
        practice.setEnd_date(end_date);

        // When
        Date result = new Date(practice.getEnd_date().getTime());

        // Then
        Assertions.assertEquals(end_date, result);
    }
    
}
