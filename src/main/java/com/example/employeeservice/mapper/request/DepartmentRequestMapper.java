package com.example.employeeservice.mapper.request;

import com.example.employeeservice.dto.request.DepartmentRequest;
import com.example.employeeservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentRequestMapper {
    public Department toEntity(DepartmentRequest request) {
        Department department = new Department();
        updateEntity(request, department);
        return department;
    }
    public void updateEntity(DepartmentRequest request, Department department) {
        department.setName(request.getName());
        department.setLocation(request.getLocation());
    }
}
