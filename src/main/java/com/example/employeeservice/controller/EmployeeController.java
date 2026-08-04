package com.example.employeeservice.controller;

import com.example.employeeservice.dto.*;
import com.example.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/designation/{designation}")
    public ResponseEntity<List<EmployeeResponse>> getByDesignation(@PathVariable String designation) {
        return ResponseEntity.ok(employeeService.getByDesignation(designation));
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<EmployeeNameResponse> getNameById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getNameById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(id, request));
    }

    @PatchMapping("/{id}/salary")
    public ResponseEntity<EmployeeResponse> updateSalary(@PathVariable Long id, @Valid @RequestBody UpdateSalaryRequest request) {
        return ResponseEntity.ok(employeeService.updateSalary(id, request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<EmployeeResponse> updateStatus(@PathVariable Long id, @Valid @RequestBody UpdateStatusRequest request) {
        return ResponseEntity.ok(employeeService.updateStatus(id, request));
    }
}
