// package com.uah.gestion_de_practicas.controller;

// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.List;

// import org.junit.Test;
// import org.junit.jupiter.api.DisplayName;
// import org.springframework.http.ResponseEntity;

// import com.uah.gestion_de_practicas.controller.dto.PracticeAssignmentDTO;
// import com.uah.gestion_de_practicas.model.Practice;
// import com.uah.gestion_de_practicas.model.Student;
// import com.uah.gestion_de_practicas.service.PracticeService;
// import com.uah.gestion_de_practicas.service.RequestService;

// @DisplayName("Practice Controller Unit Tests")
// public class PracticeControllerTest {

//     private RequestService requestService;
//     private PracticeService practiceService;

//     public PracticeControllerTest(){
//         this.requestService = mock(RequestService.class);
//         this.practiceService = mock(PracticeService.class);
//     }
 
//     @Test
//     @DisplayName("Test getPractices")
//     public void testGetPractices(){
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);
//         List<Practice> expected_practices = List.of(new Practice());
//         when(practiceService.getAllPractices()).thenReturn(expected_practices);

//         // Execute test
//         ResponseEntity<List<Practice>> response = practiceController.getPractices();

//         // Verify results
//         verify(practiceService).getAllPractices();
//         assertEquals(expected_practices, response.getBody());
//     }

//     @Test
//     @DisplayName("Test getPracticeById")
//     public void testGetPracticeById(){
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);
//         Practice expected_practice = new Practice();
//         expected_practice.setId(1L);
//         when(practiceService.getPractice(1L)).thenReturn(expected_practice);

//         // Execute test
//         ResponseEntity<Practice> response = practiceController.getPracticeById(1L);

//         // Verify results
//         verify(practiceService).getPractice(1L);
//         assertEquals(expected_practice, response.getBody());
//     }

//     @Test
//     @DisplayName("Test savePractice")
//     public void testSavePractice(){
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);
//         Practice expected_practice = new Practice();
//         when(practiceService.savePractice(expected_practice)).thenReturn(expected_practice);

//         // Execute test
//         ResponseEntity<Practice> response = practiceController.savePractice(expected_practice);

//         // Verify results
//         verify(practiceService).savePractice(expected_practice);
//         assertEquals(expected_practice, response.getBody());
//     }

//     @Test
//     @DisplayName("Test deletePractice")
//     public void testDeletePractice(){
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);

//         // Execute test
//         ResponseEntity<Practice> response = practiceController.deletePractice(1L);

//         // Verify results
//         verify(practiceService).deletePractice(1L);
//         assertTrue(response.getStatusCode().is2xxSuccessful());
//     }

//     @Test
//     @DisplayName("Test assignStudentToPractice")
//     public void testAssignStudentToPractice(){
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);
//         Practice expected_practice = new Practice();
//         expected_practice.setId(1L);
//         Student expected_student = new Student();
//         expected_student.setId(1L);
//         expected_practice.setStudent_id(expected_student.getId());

//         List<Practice> saved_practices = List.of(expected_practice);
//         PracticeAssignmentDTO expected_assignment = new PracticeAssignmentDTO(expected_student.getId(), expected_practice.getId());
//         List<PracticeAssignmentDTO> expected_assignments = List.of(expected_assignment);

//         when(requestService.getPracticeAssignments()).thenReturn(saved_practices);
//         when(practiceService.saveAllPractices(saved_practices)).thenReturn(saved_practices);

//         // Execute test
//         ResponseEntity<List<PracticeAssignmentDTO>> response = practiceController.assignPractices();

//         // Verify results
//         verify(requestService).getPracticeAssignments();
//         verify(practiceService).saveAllPractices(saved_practices);
//         assertEquals(expected_assignments, response.getBody());
//     }

//     @Test
//     @DisplayName("Test getPracticesReport")
//     public void getPracticesReport() {
//         // Set up test
//         PracticeController practiceController = new PracticeController(practiceService, requestService);
//         List<Practice> expected_practices = List.of(new Practice());
//         when(practiceService.getReport()).thenReturn(expected_practices);

//         // Execute test
//         ResponseEntity<List<Practice>> response = practiceController.getPracticesReport();

//         // Verify results
//         verify(practiceService).getReport();
//         assertEquals(expected_practices, response.getBody());
//     }
// }
