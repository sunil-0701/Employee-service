package com.example.employeeservice.mapper.response;

import com.example.employeeservice.dto.response.DepartmentResponse;
import com.example.employeeservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentResponseMapper {
    public DepartmentResponse toResponse(Department department) {
        return new DepartmentResponse(department.getId(), department.getName(), department.getLocation());
    }
}
