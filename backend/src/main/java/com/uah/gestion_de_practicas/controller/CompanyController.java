package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uah.gestion_de_practicas.controller.dto.CompanyStudentsDTO;
import com.uah.gestion_de_practicas.controller.dto.ReportDTO;
import com.uah.gestion_de_practicas.controller.dto.StudentDTO;
import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.repository.dao.ReportDAO;
import com.uah.gestion_de_practicas.repository.dao.SimplePracticeDAO;
import com.uah.gestion_de_practicas.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for the Company endpoint
 */
@RestController
@Slf4j
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Endpoint to register a new company
     * Only the tutor can register a new company
     * The company will be assigned to the tutor who is registering it
     * @param company, the company to be registered
     * @return the registered company in the body of the response
     */
    @PreAuthorize("hasRole('ROLE_TUTOR')")
    @PostMapping("")
    @ApiOperation("Registration of a new company by a tutor")
    public ResponseEntity<Company> registerCompany(
            @ApiParam("The company to be registered") @RequestBody Company company) {
        if (company == null || company.getId() != null) {
            log.warn("Bad request to register a company");
            return ResponseEntity.badRequest().build();
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Company registered_company = companyService.saveCompanyByTutor(company, username);
        if (registered_company == null) {
            log.warn("The user is not allowed to register a company");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        log.info("Company registered successfully");
        return ResponseEntity.ok(registered_company);
    }

    /**
     * Endpoint to obtain the list of companies with the number of students doing their practices in each one
     * Only the supervisor can obtain this list
     * @return the list of companies with their students in the body of the response
     */
    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("")
    @ApiOperation("The supervisor gets an overview of the companies with the number of students doing their practices in each one")
    public ResponseEntity<List<CompanyStudentsDTO>> getAllCompaniesWithStudents() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<CompanyStudentsDTO> companies_with_students = CompanyStudentsDTO
                .fromDAO(companyService.getAllCompaniesWithStudents(username));
        if (companies_with_students == null) {
            log.warn("Only the supervisor is allowed to obtain the list of companies with their students");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info(
                "The supervisor has obtained the list of companies with their students");
        return ResponseEntity.ok(companies_with_students);
    }
    
    /**
     * Endpoint to obtain the information of a company
     * @param id, the id of the company
     * @return the company information in the body of the response
     */
    @GetMapping("/{id}")
    @ApiOperation("Obtaining the information of a company")
    public ResponseEntity<Company> getCompanyById(@ApiParam("The id of the company") @PathVariable(name = "id") Long id) {
        if (id == null) {
            log.warn("Bad request to obtain the information of a company");
            return ResponseEntity.badRequest().build();
        }
        Company company = companyService.getCompany(id);
        if (company == null) {
            log.warn("The company requested does not exist");
            return ResponseEntity.notFound().build();
        }
        log.info("The company information has been obtained successfully");
        return ResponseEntity.ok(company);
    }

    /**
     * Endpoint to modify the information of a company
     * Only the tutor of the company can modify the information of a company
     * @param id, the id of the company
     * @param company, the company object with the new information
     * @return the modified company in the body of the response
     */
    @PreAuthorize("hasRole('ROLE_TUTOR')")
    @PostMapping("/{id}")
    @ApiOperation("Modifying the information of a company")
    public ResponseEntity<Company> modifyCompany(@ApiParam("The id of the company") @PathVariable(name = "id") Long id, @ApiParam("The company object with the new information") @RequestBody Company company) {
        if (id == null || company == null || !id.equals(company.getId())) {
            log.warn("Bad request to modify the information of a company");
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            log.warn("The company requested does not exist");
            return ResponseEntity.notFound().build();
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Company modified_company = companyService.updateCompanyByTutor(company, username);
        if (modified_company == null) {
            log.warn("The user is not allowed to modify the information of a company");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("The company information has been modified successfully");
        return ResponseEntity.ok(modified_company);
    }

    /**
     * Endpoint to obtain the list of actual students in a company
     * Only the tutor of the company or the supervisor can obtain this list
     * @param id, the id of the company
     * @return the list of students in the body of the response
     */
    @PreAuthorize("hasRole('ROLE_TUTOR')")
    @GetMapping("/{id}/students")
    @ApiOperation("The tutor of a company gets the list of actual students in the company")
    public ResponseEntity<List<StudentDTO>> getStudentsInCompany(@ApiParam("The id of the company") @PathVariable(name = "id") Long id) {
        if (id == null) {
            log.warn("Bad request to obtain the list of students in a company");
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            log.warn("The company requested does not exist");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<StudentDTO> students = StudentDTO.fromStudents(companyService.getStudentsInCompany(id, username));
        if (students == null) {
            log.warn("The user is not allowed to obtain the list of students in a company");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("The list of students in the company has been obtained successfully");
        return ResponseEntity.ok(students);
    }
    
    /**
     * Endpoint to publish the reports of the students in a company
     * Only the tutor of the company can publish the reports
     * @param id, the id of the company
     * @param practices, the list of practices with the reports to be published
     * @return the list of reports of the students in the body of the response
     */
    @PreAuthorize("hasRole('ROLE_TUTOR')")
    @PostMapping("/{id}/practice")
    @ApiOperation("The tutor of a company publishes the reports of the students in the company")
    public ResponseEntity<List<SimplePracticeDAO>> publishReports(@ApiParam("The id of the company") @PathVariable(name = "id") Long id, @ApiParam("The list of practices DTO with the reports to be published") @RequestBody List<ReportDTO> practices) {
        if (id == null || practices == null) {
            log.warn("Bad request to publish the reports of the students in a company");
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            log.warn("The company requested does not exist");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Practice> updated_practices = companyService.publishReports(ReportDAO.fromDTO(practices), username);
        if (updated_practices == null) {
            log.warn("The user is not allowed to publish the reports of the students in a company");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("The reports of the students in the company have been published successfully");
        return ResponseEntity.ok(SimplePracticeDAO.fromPractices(updated_practices));
    }
    
    /**
     * Endpoint to obtain the history of practices of a company
     * Only the tutor of the company or the supervisor can obtain this history
     * @param id, the id of the company
     * @return the list of practices in the body of the response
     */
    @PreAuthorize("hasAnyRole('ROLE_TUTOR','ROLE_SUPERVISOR')")
    @GetMapping("/{id}/practice")
    @ApiOperation("The tutor of a company gets the history of practices of the company, completed or in progress")
    public ResponseEntity<List<SimplePracticeDAO>> getPracticeHistory(@ApiParam("The id of the company") @PathVariable(name = "id") Long id) {
        if (id == null) {
            log.warn("Bad request to obtain the history of practices of a company");
            return ResponseEntity.badRequest().build();
        }
        if (companyService.getCompany(id) == null) {
            log.warn("The company requested does not exist");
            return ResponseEntity.notFound().build();
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<SimplePracticeDAO> practices = companyService.getPracticeHistory(id, username);
        if (practices == null) {
            log.warn("The user is not allowed to obtain the history of practices of a company");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        log.info("The history of practices of the company has been obtained successfully");
        return ResponseEntity.ok(practices);
    }
    
}
