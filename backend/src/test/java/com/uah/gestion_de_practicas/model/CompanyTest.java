package com.uah.gestion_de_practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CompanyTest")
public class CompanyTest {
    private Company company;

    @BeforeEach
    public void setUp() {
        company = new Company();
    }

    @Test
    @DisplayName("`getId` should return the id of the company.")
    public void TestGetId() {
        // Given
        Long id = 1L;
        company.setId(id);

        // When
        Long result = company.getId();

        // Then
        Assertions.assertEquals(id, result);
    }

    @Test
    @DisplayName("`getName` should return the name of the company.")
    public void TestGetName() {
        // Given
        String name = "Google";
        company.setName(name);

        // When
        String result = company.getName();

        // Then
        Assertions.assertEquals(name, result);
    }

    @Test
    @DisplayName("`getDescription` should return the description of the company.")
    public void TestGetDescription() {
        // Given
        String description = "A technology company that specializes in Internet services and products.";
        company.setDescription(description);

        // When
        String result = company.getDescription();

        // Then
        Assertions.assertEquals(description, result);
    }

    @Test
    @DisplayName("`getTutorId` should return the id of the tutor.")
    public void TestGetTutorId() {
        // Given
        Long tutor_id = 1L;
        company.setTutor_id(tutor_id);

        // When
        Long result = company.getTutor_id();

        // Then
        Assertions.assertEquals(tutor_id, result);
    }
    
}
