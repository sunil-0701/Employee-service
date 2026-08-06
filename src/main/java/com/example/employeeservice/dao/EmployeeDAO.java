package com.example.employeeservice.dao;

import com.example.employeeservice.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeDAO {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    Optional<Employee> findByEmail(String email);
    List<Employee> findAll();
    List<Employee> findByDesignation(String designation);
    Page<Employee> findAll(Pageable pageable);
}
