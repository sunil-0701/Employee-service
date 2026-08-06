package com.example.employeeservice.dao;

import com.example.employeeservice.entity.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentDAO {
    Department save(Department department);
    Optional<Department> findById(Long id);
    List<Department> findAll();
    boolean existsByName(String name);
    void delete(Department department);
}
