package com.uah.gestion_de_practicas.controller;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.uah.gestion_de_practicas.controller.dto.CompanyStudentsDTO;
import com.uah.gestion_de_practicas.controller.dto.StudentDTO;
import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Student;
import com.uah.gestion_de_practicas.model.Supervisor;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.service.CompanyService;
import com.uah.gestion_de_practicas.service.OfferService;
import com.uah.gestion_de_practicas.service.PracticeService;
import com.uah.gestion_de_practicas.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("Company Controller Unit Tests")
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;

    @Autowired
    private OfferService offerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private CompanyService companyService;

    @Test
    public void registerCompany() {
        // Set up test
        Company company = new Company("Company Example", "Description Example");
        Tutor tutor = new Tutor("gonza", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com",
                        Date.valueOf("2021-05-01"), null, company);

        // Execute the method
        Company registered_company = companyController.registerCompany(company, tutor).getBody();
        HttpStatus status_unregistered = companyController.registerCompany(company, null).getStatusCode();

        // Assert the result
        assertEquals(company, registered_company);
        assertEquals(HttpStatus.BAD_REQUEST, status_unregistered);
    }

    @Test
    public void getAllCompaniesWithStudents() {
        // Set up test
        Company company = new Company("Company 1", "Description 1");

        company = companyService.saveCompany(company);

        Offer offer1 = new Offer("Backend developer", "Web", company.getId(), "Street", "None", "Description 1",
                "8 hours per day", 12, 500.0, 5);
        Offer offer2 = new Offer("Frontend developer", "Web", company.getId(), "Street", "None", "Description 1",
                "8 hours per day", 12, 500.0, 5);

        offerService.saveOffer(offer1);
        offerService.saveOffer(offer2);

        Student student1 = new Student("gonza", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com", "GII",
                Date.valueOf("2001-01-03"), "612345678", 8.9, 300);
        Student student2 = new Student("gonza2", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com", "GII",
                Date.valueOf("2001-01-03"), "612345678", 8.9, 300);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        Practice practice1 = new Practice(student1.getId(), offer1.getId(), null, null, null, null);
        Practice practice2 = new Practice(student2.getId(), offer2.getId(), null, null, null, null);

        practiceService.savePractice(practice1);
        practiceService.savePractice(practice2);

        Supervisor supervisor = new Supervisor("gonza", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com",
                Date.valueOf("2021-05-01"), null);

        // Execute the method
        List<CompanyStudentsDTO> companies = companyController.getAllCompaniesWithStudents(supervisor).getBody();

        // Assert the result
        List<CompanyStudentsDTO> expected_companies = List.of(new CompanyStudentsDTO(company.getId(), company.getName(), company.getDescription(), 2L));

        assertEquals(expected_companies, companies);
    }

    @Test
    public void getCompanyById() {
        // Set up test
        Company company = new Company("Company 1", "Description 1");

        Company saved_company = companyService.saveCompany(company);

        Company company_found = companyController.getCompanyById(company.getId()).getBody();
        HttpStatus status_not_found = companyController.getCompanyById(5L).getStatusCode();

        // Assert the result
        assertEquals(saved_company, company_found);
        assertEquals(HttpStatus.NOT_FOUND, status_not_found);
    }
    
    @Test
    public void modifyCompany() {
        // Set up test
        Company company = new Company("Company 1", "Description 1");

        Company saved_company = companyService.saveCompany(company);

        // Execute the method
        Company modified_company = companyController.modifyCompany(saved_company.getId(), saved_company).getBody();
        HttpStatus status_not_found = companyController.modifyCompany(5L, company).getStatusCode();

        // Assert the result
        assertEquals(saved_company, modified_company);
        assertEquals(HttpStatus.NOT_FOUND, status_not_found);
    }
    
    @Test
    public void getStudentsInCompany() {
        // Set up test
        Company company = new Company("Company 1", "Description 1");

        Company company_saved = companyService.saveCompany(company);

        Offer offer1 = new Offer("Backend developer", "Web", company.getId(), "Street", "None", "Description 1",
                        "8 hours per day", 12, 500.0, 5);
        Offer offer2 = new Offer("Frontend developer", "Web", company.getId(), "Street", "None", "Description 1",
                        "8 hours per day", 12, 500.0, 5);

        offerService.saveOffer(offer1);
        offerService.saveOffer(offer2);

        Tutor tutor = new Tutor("gonza", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com",
                        Date.valueOf("2021-05-01"), null, company);

        Student student1 = new Student("gonza", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com", "GII",
                        Date.valueOf("2001-01-03"), "612345678", 8.9, 300);
        Student student2 = new Student("gonza2", "1234", "Gonzalo", "López", "12345566X", "gonza@gmail.com", "GII",
                        Date.valueOf("2001-01-03"), "612345678", 8.9, 300);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        Practice practice1 = new Practice(student1.getId(), offer1.getId(), null, null, null, null);
        Practice practice2 = new Practice(student2.getId(), offer2.getId(), null, null, null, null);

        practiceService.savePractice(practice1);
        practiceService.savePractice(practice2);

        List<StudentDTO> expected_list = List.of(new StudentDTO(student1), new StudentDTO(student2));
        List<StudentDTO> students = companyController.getStudentsInCompany(company_saved.getId(), tutor).getBody();

        assertEquals(expected_list, students);

    }
    
    @Test
    public void publishReports() {
        // Set up test

        Company c1 = new Company("Company1", "Description 1");
        c1 = companyService.saveCompany(c1);

        Practice p1 = new Practice(1L, 1L, null, null, null, null);
        Practice p2 = new Practice(2L, 2L, null, null, null, null);

        p1 = practiceService.savePractice(p1);
        p2 = practiceService.savePractice(p2);

        p1.setReport("Well done");
        p1.setMark(9.4);
        p2.setReport("Expected more");
        p2.setMark(5.1);

        List<Practice> practices_to_save = List.of(p1, p2);
        // Execute the method
        List<Practice> practices = companyController.publishReports(c1.getId(), practices_to_save).getBody();
        
        // Assert the result
        assertEquals(practices_to_save, practices);
    }

    
}
