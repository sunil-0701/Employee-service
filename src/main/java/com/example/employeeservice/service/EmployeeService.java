package com.example.employeeservice.service;

import com.example.employeeservice.dto.*;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.repository.DepartmentRepository;
import com.example.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeResponse create(EmployeeRequest request) {
        if (employeeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        Employee employee = new Employee();
        copyRequest(request, employee);
        return toResponse(employeeRepository.save(employee));
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public EmployeeResponse getById(Long id) {
        return toResponse(findEntity(id));
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee employee = findEntity(id);
        if (!employee.getEmail().equals(request.getEmail()) && employeeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        copyRequest(request, employee);
        return toResponse(employeeRepository.save(employee));
    }

    public void delete(Long id) {
        employeeRepository.delete(findEntity(id));
    }

    private Employee findEntity(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }
    private Department findDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }
    private void copyRequest(EmployeeRequest request, Employee employee) {
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setJoinDate(request.getJoinDate());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setAddress(request.getAddress());
        employee.setDepartment(findDepartment(request.getDepartmentId()));
    }
    private EmployeeResponse toResponse(Employee employee) {
        Department department = employee.getDepartment();
        DepartmentResponse departmentResponse = new DepartmentResponse(department.getId(), department.getName(), department.getLocation());
        return new EmployeeResponse(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getDateOfBirth(), employee.getJoinDate(), employee.getSalary(),
                employee.getDesignation(), employee.getAddress(), departmentResponse);
    }
}
