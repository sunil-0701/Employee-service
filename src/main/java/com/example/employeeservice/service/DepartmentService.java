package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentRequest;
import com.example.employeeservice.dto.DepartmentResponse;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponse create(DepartmentRequest request) {
        if (departmentRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Department name already exists");
        }
        Department department = new Department();
        copyRequest(request, department);
        return toResponse(departmentRepository.save(department));
    }

    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAll() {
        return departmentRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public DepartmentResponse getById(Long id) { return toResponse(findEntity(id)); }

    public DepartmentResponse update(Long id, DepartmentRequest request) {
        Department department = findEntity(id);
        if (!department.getName().equals(request.getName()) && departmentRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Department name already exists");
        }
        copyRequest(request, department);
        return toResponse(departmentRepository.save(department));
    }

    public void delete(Long id) { departmentRepository.delete(findEntity(id)); }

    private Department findEntity(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }
    private void copyRequest(DepartmentRequest request, Department department) {
        department.setName(request.getName());
        department.setLocation(request.getLocation());
    }
    public DepartmentResponse toResponse(Department department) {
        return new DepartmentResponse(department.getId(), department.getName(), department.getLocation());
    }
}
