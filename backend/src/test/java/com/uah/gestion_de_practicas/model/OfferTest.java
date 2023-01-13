package com.uah.gestion_de_practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OfferTest")
public class OfferTest {
    private Offer offer;

    @BeforeEach
    public void setUp() {
        offer = new Offer();
    }

    @Test
    @DisplayName("`getId` should return the id of the offer.")
    public void TestGetId() {
        // Given
        Long id = 1L;
        offer.setId(id);

        // When
        Long result = offer.getId();

        // Then
        Assertions.assertEquals(id, result);
    }
    
    @Test
    @DisplayName("`getPosition` should return the job position of the internship offer.")
    public void TestGetPosition() {
        // Given
        String position = "Desarrollador Web Spring";
        offer.setPosition(position);

        // When
        String result = offer.getPosition();

        // Then
        Assertions.assertEquals(position, result);
    }

    @Test
    @DisplayName("`getCategory` should return the category of the internship offer.")
    public void TestGetCategory() {
        // Given
        String category = "Desarrollo Web";
        offer.setCategory(category);

        // When
        String result = offer.getCategory();

        // Then
        Assertions.assertEquals(category, result);
    }

    @Test
    @DisplayName("`getCompany_id` should return the id of the company that offers the internship.")
    public void TestGetCompany_id() {
        // Given
        Company company = new Company();
        company.setId(1L);
        offer.setCompany(company);

        // When
        Long result = offer.getCompany().getId();

        // Then
        Assertions.assertEquals(company.getId(), result);
    }

    @Test
    @DisplayName("`getAddress` should return the address of the company that offers the internship.")
    public void TestGetAddress() {
        // Given
        String address = "Calle Mayor, 30, 28001 Madrid";
        offer.setAddress(address);

        // When
        String result = offer.getAddress();

        // Then
        Assertions.assertEquals(address, result);
    }

    @Test
    @DisplayName("`getRequirements` should return the requirements of the internship offer.")
    public void TestGetRequirements() {
        // Given
        String requirements = "Conocimientos de Java, Spring, HTML, CSS, JavaScript, MySQL";
        offer.setRequirements(requirements);

        // When
        String result = offer.getRequirements();

        // Then
        Assertions.assertEquals(requirements, result);
    }

    @Test
    @DisplayName("`getDescription` should return the description of the internship offer.")
    public void TestGetDescription() {
        // Given
        String description = "Desarrollo de una aplicación web para la gestión de prácticas de la Universidad";
        offer.setDescription(description);

        // When
        String result = offer.getDescription();

        // Then
        Assertions.assertEquals(description, result);
    }

    @Test
    @DisplayName("`getSchedule` should return the schedule of the internship offer.")
    public void TestGetSchedule() {
        // Given
        String schedule = "8-14h";
        offer.setSchedule(schedule);

        // When
        String result = offer.getSchedule();

        // Then
        Assertions.assertEquals(schedule, result);
    }

    @Test
    @DisplayName("`getWeeks` should return the weeks of the internship offer.")
    public void TestGetWeeks() {
        // Given
        Integer weeks = 6;
        offer.setWeeks(weeks);

        // When
        Integer result = offer.getWeeks();

        // Then
        Assertions.assertEquals(weeks, result);
    }

    @Test
    @DisplayName("`getSalary` should return the salary of the internship offer.")
    public void TestGetSalary() {
        // Given
        Double salary = 600.0;
        offer.setSalary(salary);

        // When
        Double result = offer.getSalary();

        // Then
        Assertions.assertEquals(salary, result);
    }

    @Test
    @DisplayName("`getVacancies` should return the number of total vacancies of the internship offer.")
    public void TestGetVacancies() {
        // Given
        Integer vacancies = 2;
        offer.setVacancies(vacancies);

        // When
        Integer result = offer.getVacancies();

        // Then
        Assertions.assertEquals(vacancies, result);
    }
}
