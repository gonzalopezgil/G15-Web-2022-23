package com.uah.gestion_de_practicas.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.uah.gestion_de_practicas.model.Request;
import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.service.RequestService;
import com.uah.gestion_de_practicas.repository.RequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@DisplayName("User Service Test")
public class RequestServiceTest {

    private RequestService requestService;
    private RequestRepository requestRepository = mock(RequestRepository.class);
    private StudentService studentService = mock(StudentService.class);
    private OfferService offerService = mock(OfferService.class);

    public RequestServiceTest() {
        this.requestService = new RequestService(this.requestRepository, this.studentService, this.offerService);
    }

    @Test
    @DisplayName("Test saveRequest")
    public void testSaveRequest() {
        // Set up test
        Request request = new Request();

        // Execute test
        requestService.saveRequest(request);

        // Verify results
        verify(requestRepository).save(request);
    }

    @Test
    @DisplayName("Test getRequest")
    public void testGetRequest() {
        // Set up test
        Request request = new Request();
        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));

        // Execute test
        Request result = requestService.getRequest(1L);

        // Verify results
        verify(requestRepository).findById(1L);
        assertTrue(result != null);
    }

    @Test
    @DisplayName("Test getAllRequests")
    public void testGetAllRequests() {
        // Set up test
        List<Request> requests = new ArrayList<Request>();
        when(requestRepository.findAll()).thenReturn(requests);

        // Execute test
        List<Request> result = requestService.getAllRequests();

        // Verify results
        verify(requestRepository).findAll();
        assertTrue(result != null);
    }

    @Test
    @DisplayName("Test deleteRequest")
    public void testDeleteRequest() {
        // Set up test
        Request request = new Request();
        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));

        // Execute test
        requestService.deleteRequest(1L);

        // Verify results
        verify(requestRepository).findById(1L);
        verify(requestRepository).deleteById(1L);
    }
}
