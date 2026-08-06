package com.example.employeeservice.service;

import com.example.employeeservice.dto.request.*;
import com.example.employeeservice.dto.response.*;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse create(EmployeeRequest request);
    GetEmployeeResponse getAll(int currentPage, int perPage);
    List<EmployeeResponse> getByDesignation(String designation);
    EmployeeResponse getById(Long id);
    EmployeeNameResponse getNameById(Long id);
    EmployeeResponse update(Long id, EmployeeRequest request);
    EmployeeResponse updateSalary(Long id, UpdateSalaryRequest request);
    EmployeeResponse updateStatus(Long id, UpdateStatusRequest request);
}
