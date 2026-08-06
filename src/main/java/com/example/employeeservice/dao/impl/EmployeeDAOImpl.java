package com.example.employeeservice.dao.impl;

import com.example.employeeservice.dao.EmployeeDAO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EmployeeRepository employeeRepository;
    public Employee save(Employee employee) { return employeeRepository.save(employee); }
    public Optional<Employee> findById(Long id) { return employeeRepository.findById(id); }
    public Optional<Employee> findByEmail(String email) { return employeeRepository.findByEmail(email); }
    public List<Employee> findAll() { return employeeRepository.findAll(); }
    public List<Employee> findByDesignation(String designation) { return employeeRepository.findByDesignationIgnoreCase(designation); }
    public Page<Employee> findAll(Pageable pageable) { return employeeRepository.findAll(pageable); }
}
