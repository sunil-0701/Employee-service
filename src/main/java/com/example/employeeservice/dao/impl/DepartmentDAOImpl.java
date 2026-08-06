package com.example.employeeservice.dao.impl;

import com.example.employeeservice.dao.DepartmentDAO;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentDAOImpl implements DepartmentDAO {
    private final DepartmentRepository departmentRepository;
    public Department save(Department department) { return departmentRepository.save(department); }
    public Optional<Department> findById(Long id) { return departmentRepository.findById(id); }
    public List<Department> findAll() { return departmentRepository.findAll(); }
    public boolean existsByName(String name) { return departmentRepository.existsByName(name); }
    public void delete(Department department) { departmentRepository.delete(department); }
}
