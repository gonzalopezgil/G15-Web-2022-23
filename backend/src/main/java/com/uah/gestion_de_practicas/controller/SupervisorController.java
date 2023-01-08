package com.uah.gestion_de_practicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uah.gestion_de_practicas.controller.dto.SupervisorDTO;
import com.uah.gestion_de_practicas.model.Supervisor;
import com.uah.gestion_de_practicas.service.SupervisorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/users/supervisors")
public class SupervisorController {
    private final SupervisorService supervisorService;
    
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    // ------------------- CRUD OPERATIONS ------------------- //
    @GetMapping("")
    @ApiOperation(value = "Get all supervisors")
    public ResponseEntity<List<SupervisorDTO>> getSupervisors() {
        return ResponseEntity.ok(SupervisorDTO.fromSupervisors(supervisorService.getAllSupervisors()));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a supervisor by id")
    public ResponseEntity<SupervisorDTO> getSupervisorById(@ApiParam("Identifier of the supervisor") @PathVariable Long id) {
        return ResponseEntity.ok(SupervisorDTO.fromSupervisor(supervisorService.getSupervisor(id)));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a supervisor by id")
    public ResponseEntity updateSupervisor(@ApiParam("Identifier of the supervisor") @PathVariable Long id, @ApiParam("New object for the supervisor") @RequestBody Supervisor supervisor) {
        if (supervisor.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        
        supervisorService.saveSupervisor(supervisor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a supervisor by id")
    public ResponseEntity deleteSupervisor(@ApiParam("Identifier of the supervisor") @PathVariable Long id) {
        if (supervisorService.getSupervisor(id) == null) {
            return ResponseEntity.notFound().build();
        }

        supervisorService.deleteSupervisor(id);
        return ResponseEntity.ok().build();
    }

    
}