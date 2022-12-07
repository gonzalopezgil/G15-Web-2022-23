package com.uah.gestion_de_practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.uah.gestion_de_practicas.repository.DAO.SelectionIdentity;

@DisplayName("SelectionTest")
public class SelectionTest {
    private Selection selection;
    private SelectionIdentity selectionIdentity;

    @BeforeEach
    public void setUp() {
        selection = new Selection();
        selectionIdentity = new SelectionIdentity();
    }

    @Test
    @DisplayName("`getStudent_id` should return the id of the student that made the selection.")
    public void TestGetStudent_id() {
        // Given
        Long student_id = 1L;
        selectionIdentity.setStudent_id(student_id);
        selection.setSelectionIdentity(selectionIdentity);

        // When
        Long result = selection.getSelectionIdentity().getStudent_id();

        // Then
        Assertions.assertEquals(student_id, result);
    }

    @Test
    @DisplayName("`getOffer_id` should return the id of the offer that the student selected.")
    public void TestGetOffer_id() {
        // Given
        Long offer_id = 1L;
        selectionIdentity.setOffer_id(offer_id);
        selection.setSelectionIdentity(selectionIdentity);

        // When
        Long result = selection.getSelectionIdentity().getOffer_id();

        // Then
        Assertions.assertEquals(offer_id, result);
    }

    @Test
    @DisplayName("`getPreference` should return the preference of the student for the offer.")
    public void TestGetPreference() {
        // Given
        Integer preference = 1;
        selection.setPreference(preference);

        // When
        Integer result = selection.getPreference();

        // Then
        Assertions.assertEquals(preference, result);
    }
    
}
