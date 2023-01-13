package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TutorTest")
public class TutorTest {
    private Tutor tutor;

    @BeforeEach
    public void setUp() {
        tutor = new Tutor();
    }

    @Test
    @DisplayName("`getId` should return the id of the tutor.")
    public void TestGetId() {
        // Given
        Long id = 1L;
        tutor.setId(id);

        // When
        Long result = tutor.getId();

        // Then
        Assertions.assertEquals(id, result);
    }

    @Test
    @DisplayName("`getUsername` should return the username of the tutor.")
    public void TestGetUsername() {
        // Given
        String username = "gonzalo_LG09";
        tutor.setUsername(username);

        // When
        String result = tutor.getUsername();

        // Then
        Assertions.assertEquals(username, result);
    }

    @Test
    @DisplayName("`getPassword` should return the password of the tutor.")
    public void TestGetPassword() {
        // Given
        String password = "webweb09GII";
        tutor.setPassword(password);

        // When
        String result = tutor.getPassword();

        // Then
        Assertions.assertEquals(password, result);
    }

    @Test
    @DisplayName("`getFirstName` should return the first name of the tutor.")
    public void TestGetFirstName() {
        // Given
        String firstName = "Gonzalo";
        tutor.setFirst_name(firstName);

        // When
        String result = tutor.getFirst_name();

        // Then
        Assertions.assertEquals(firstName, result);
    }

    @Test
    @DisplayName("`getLastName` should return the last name of the tutor.")
    public void TestGetLastName() {
        // Given
        String lastName = "López";
        tutor.setLast_name(lastName);

        // When
        String result = tutor.getLast_name();

        // Then
        Assertions.assertEquals(lastName, result);
    }

    @Test
    @DisplayName("`getNif` should return the nif of the tutor.")
    public void TestGetNif() {
        // Given
        String nif = "03101010X";
        tutor.setNif(nif);

        // When
        String result = tutor.getNif();

        // Then
        Assertions.assertEquals(nif, result);
    }

    @Test
    @DisplayName("`getEmail` should return the email of the tutor.")
    public void TestGetEmail() {
        // Given
        String email = "gonzalo@mail.com";
        tutor.setEmail(email);

        // When
        String result = tutor.getEmail();

        // Then
        Assertions.assertEquals(email, result);
    }

    @Test
    @DisplayName("`getAdmissionDate` should return the admission date of the tutor.")
    public void TestGetAdmissionDate() {
        // Given
        Date admissionDate = Date.valueOf("2020-04-15");
        tutor.setAdmission_date(admissionDate);

        // When
        Date result = tutor.getAdmission_date();

        // Then
        Assertions.assertEquals(admissionDate, result);
    }

    @Test
    @DisplayName("`getRemovalDate` should return the removal date of the tutor.")
    public void TestGetRemovalDate() {
        // Given
        Date removalDate = Date.valueOf("2021-01-10");
        tutor.setRemoval_date(removalDate);

        // When
        Date result = tutor.getRemoval_date();

        // Then
        Assertions.assertEquals(removalDate, result);
    }

    @Test
    @DisplayName("`getCompany` should return the company id of the tutor.")
    public void TestGetCompany() {
        // Given
        Company company = new Company();
        company.setId(1L);
        tutor.setCompany(company);

        // When
        Company result = tutor.getCompany();

        // Then
        Assertions.assertEquals(company, result);
    }

}
