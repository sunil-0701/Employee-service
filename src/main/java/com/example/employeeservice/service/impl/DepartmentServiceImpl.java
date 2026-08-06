package com.example.employeeservice.service.impl;

import com.example.employeeservice.constants.MessageConstants;
import com.example.employeeservice.dao.DepartmentDAO;
import com.example.employeeservice.dto.request.DepartmentRequest;
import com.example.employeeservice.dto.response.DepartmentResponse;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.mapper.request.DepartmentRequestMapper;
import com.example.employeeservice.mapper.response.DepartmentResponseMapper;
import com.example.employeeservice.service.DepartmentService;
import com.example.employeeservice.validator.DepartmentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;
    private final DepartmentValidator departmentValidator;
    private final DepartmentRequestMapper departmentRequestMapper;
    private final DepartmentResponseMapper departmentResponseMapper;
    public DepartmentResponse create(DepartmentRequest request) {
        departmentValidator.validateNewName(request.getName());
        return departmentResponseMapper.toResponse(departmentDAO.save(departmentRequestMapper.toEntity(request)));
    }
    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAll() {
        return departmentDAO.findAll().stream().map(departmentResponseMapper::toResponse).toList();
    }
    @Transactional(readOnly = true)
    public DepartmentResponse getById(Long id) { return departmentResponseMapper.toResponse(findDepartment(id)); }
    public DepartmentResponse update(Long id, DepartmentRequest request) {
        Department department = findDepartment(id);
        departmentValidator.validateUpdatedName(department, request.getName());
        departmentRequestMapper.updateEntity(request, department);
        return departmentResponseMapper.toResponse(departmentDAO.save(department));
    }
    public void delete(Long id) { departmentDAO.delete(findDepartment(id)); }
    private Department findDepartment(Long id) {
        return departmentDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageConstants.DEPARTMENT_NOT_FOUND + id));
    }
}
