package com.uah.gestion_de_practicas.model;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StudentTest")
public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student();
    }

    @Test
    @DisplayName("`getId` should return the id of the student.")
    public void TestGetId() {
        // Given
        Long id = 4L;
        student.setId(id);

        // When
        Long result = student.getId();

        // Then
        Assertions.assertEquals(id, result);
    }
    
    @Test
    @DisplayName("`getUsername` should return the username of the student.")
    public void TestGetUsername() {
        // Given
        String username = "gonzalo_LG09";
        student.setUsername(username);

        // When
        String result = student.getUsername();

        // Then
        Assertions.assertEquals(username, result);
    }

    @Test
    @DisplayName("`getPassword` should return the password of the student.")
    public void TestGetPassword() {
        // Given
        String password = "webweb09GII";
        student.setPassword(password);

        // When
        String result = student.getPassword();

        // Then
        Assertions.assertEquals(password, result);
    }

    @Test
    @DisplayName("`getFirstName` should return the first name of the student.")
    public void TestGetFirstName() {
        // Given
        String firstName = "Gonzalo";
        student.setFirst_name(firstName);

        // When
        String result = student.getFirst_name();

        // Then
        Assertions.assertEquals(firstName, result);
    }

    @Test
    @DisplayName("`getLastName` should return the last name of the student.")
    public void TestGetLastName() {
        // Given
        String lastName = "López";
        student.setLast_name(lastName);

        // When
        String result = student.getLast_name();

        // Then
        Assertions.assertEquals(lastName, result);
    }

    @Test
    @DisplayName("`getNif` should return the nif of the student.")
    public void TestGetNif() {
        // Given
        String nif = "03101010X";
        student.setNif(nif);

        // When
        String result = student.getNif();

        // Then
        Assertions.assertEquals(nif, result);
    }

    @Test
    @DisplayName("`getEmail` should return the email of the student.")
    public void TestGetEmail() {
        // Given
        String email = "gonzalo@mail.com";
        student.setEmail(email);

        // When
        String result = student.getEmail();

        // Then
        Assertions.assertEquals(email, result);
    }

    @Test
    @DisplayName("`getDegree' should return the degree of the student.")
    public void TestGetDegree() {
        // Given
        String degree = "GII";
        student.setDegree(degree);

        // When
        String result = student.getDegree();

        // Then
        Assertions.assertEquals(degree, result);
    }
    
    @Test
    @DisplayName("`getBirthDate` should return the birth date of the student.")
    public void TestGetBirthDate() {
        // Given
        Date birthDate = Date.valueOf("2000-05-30");
        student.setBirth_date(birthDate);

        // When
        Date result = student.getBirth_date();

        // Then
        Assertions.assertEquals(birthDate, result);
    }

    @Test
    @DisplayName("`getPhone` should return the phone of the student.")
    public void TestGetPhone() {
        // Given
        String phone = "+34611222333";
        student.setPhone(phone);

        // When
        String result = student.getPhone();

        // Then
        Assertions.assertEquals(phone, result);
    }

    @Test
    @DisplayName("`getExpNote` should return the average grade of the student.")
    public void TestGetExpNote() {
        // Given
        Double exp_note = 7.5;
        student.setExp_note(exp_note);

        // When
        Double result = student.getExp_note();

        // Then
        Assertions.assertEquals(exp_note, result);
    }

    @Test
    @DisplayName("`getTotalHours` should return the total hours of practice corresponding to the student.")
    public void TestGetTotalHours() {
        // Given
        Integer total_hours = 100;
        student.setTotal_hours(total_hours);

        // When
        Integer result = student.getTotal_hours();

        // Then
        Assertions.assertEquals(total_hours, result);
    }
    
}
