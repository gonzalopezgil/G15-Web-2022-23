package com.uah.gestion_de_practicas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.CompanyStudentsDTO;
import com.uah.gestion_de_practicas.controller.dto.StudentDTO;
import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Supervisor;
import com.uah.gestion_de_practicas.model.Tutor;
import com.uah.gestion_de_practicas.service.CompanyService;

/**
 * Rest Controller for the Company endpoint
 */
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Endpoint to register a new company
     * Only the tutor can register a new company
     * @param company, the company to be registered
     * @param tutor, the tutor who is registering the company
     * @return the registered company in the body of the response
     */
    @PostMapping("")
    public ResponseEntity<Company> registerCompany(@RequestBody Company company, @RequestBody Tutor tutor) {
        if (company == null || tutor == null || company.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        // TODO: Check if the tutor is registered to another company first
        Company registered_company = companyService.saveCompany(company);
        return ResponseEntity.ok(registered_company);
    }

    /**
     * Endpoint to obtain the list of companies with the number of students doing their practices in each one
     * Only the supervisor can obtain this list
     * @param supervisor, the supervisor who is requesting the list
     * @return the list of companies with their students in the body of the response
     */
    @GetMapping("")
    public ResponseEntity<List<CompanyStudentsDTO>> getAllCompaniesWithStudents(@RequestBody Supervisor supervisor) {
        if (supervisor == null) {
            return ResponseEntity.badRequest().build();
        }

        List<CompanyStudentsDTO> companies_with_students = CompanyStudentsDTO.fromDAO(companyService.getAllCompaniesWithStudents());
        return ResponseEntity.ok(companies_with_students);
    }
    
    /**
     * Endpoint to obtain the information of a company
     * @param id, the id of the company
     * @return the company information in the body of the response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(name = "id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Company company = companyService.getCompany(id);
        if (company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }

    /**
     * Endpoint to modify the information of a company
     * @param id, the id of the company
     * @param company, the company object with the new information
     * @return the modified company in the body of the response
     */
    @PostMapping("/{id}")
    public ResponseEntity<Company> modifyCompany(@PathVariable(name = "id") Long id, @RequestBody Company company) {
        if (id == null || company == null) {
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            return ResponseEntity.notFound().build();
        }
        Company modified_company = companyService.saveCompany(company);
        if (modified_company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modified_company);
    }

    /**
     * Endpoint to obtain the list of actual students in a company
     * Only the tutor of the company can obtain this list
     * @param id, the id of the company
     * @return the list of students in the body of the response
     */
    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsInCompany(@PathVariable(name = "id") Long id,
            @RequestBody Tutor tutor) {
        if (id == null || tutor == null || tutor.getCompany().getId() != id || tutor.getRemoval_date() != null) {
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            return ResponseEntity.notFound().build();
        }
        List<StudentDTO> students = StudentDTO.fromStudents(companyService.getStudentsInCompany(id));
        return ResponseEntity.ok(students);
    }
    
    /**
     * Endpoint to publish the reports of the students in a company
     * Only the tutor of the company can publish the reports
     * @param id, the id of the company
     * @param tutor, the tutor who is publishing the reports
     * @return the list of reports of the students in the body of the response
     */
    @PostMapping("/{id}/practice")
    public ResponseEntity<List<Practice>> publishReports(@PathVariable(name = "id") Long id, @RequestBody List<Practice> practices) {
        if (id == null || practices == null) {
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            return ResponseEntity.notFound().build();
        }
        List<Practice> updated_practices = companyService.publishReports(practices);
        return ResponseEntity.ok(updated_practices);
    }
    
    /**
     * Endpoint to obtain the history of practices of a company
     * Only the tutor of the company can obtain this history
     * @param id, the id of the company
     * @param tutor, the tutor who is requesting the history
     * @return the list of practices in the body of the response
     */
    @GetMapping("/{id}/practice")
    public ResponseEntity<List<Practice>> getPracticeHistory(@PathVariable(name = "id") Long id,
            @RequestBody Tutor tutor) {
        if (id == null || tutor == null || tutor.getCompany().getId() != id || tutor.getRemoval_date() != null) {
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            return ResponseEntity.notFound().build();
        }
        List<Practice> practices = companyService.getPracticeHistory(id);
        return ResponseEntity.ok(practices);
    }
    
}
