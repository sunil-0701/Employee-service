package com.example.employeeservice.service.impl;

import com.example.employeeservice.constants.MessageConstants;
import com.example.employeeservice.dao.DepartmentDAO;
import com.example.employeeservice.dao.EmployeeDAO;
import com.example.employeeservice.dto.request.*;
import com.example.employeeservice.dto.response.*;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.mapper.request.EmployeeRequestMapper;
import com.example.employeeservice.mapper.response.EmployeeResponseMapper;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.validator.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import jakarta.servlet.http.HttpServletRequest;
import com.example.employeeservice.dto.common.Meta;
import com.example.employeeservice.util.CommonUtil;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final DepartmentDAO departmentDAO;
    private final EmployeeValidator employeeValidator;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final HttpServletRequest httpRequest;

    public EmployeeResponse create(EmployeeRequest request) {
        log.info("EmployeeServiceImpl :: create() :: Init");
        employeeValidator.validateNewEmail(request.getEmail());
        Employee employee = employeeRequestMapper.convert(request, findDepartment(request.getDepartmentId()), getUserName());
        EmployeeResponse response = employeeResponseMapper.toResponse(employeeDAO.save(employee));
        log.info("EmployeeServiceImpl :: create() :: Ends");
        return response;
    }
    @Transactional(readOnly = true)
    public GetEmployeeResponse getAll(int currentPage, int perPage) {
        log.info("EmployeeServiceImpl :: getAll() :: Init");
        CommonUtil.checkPaginationParameters(currentPage, perPage);
        Page<Employee> page = employeeDAO.findAll(PageRequest.of(currentPage - 1, perPage));
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setData(page.getContent().stream().map(employeeResponseMapper::toResponse).toList());
        response.setMeta(new Meta(currentPage, perPage, page.getTotalElements(), page.getTotalPages()));
        employeeResponseMapper.setSuccess(response);
        log.info("EmployeeServiceImpl :: getAll() :: Ends");
        return response;
    }
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getByDesignation(String designation) {
        log.info("EmployeeServiceImpl :: getByDesignation() :: Init");
        List<EmployeeResponse> response = employeeDAO.findByDesignation(designation).stream().map(employeeResponseMapper::toResponse).toList();
        log.info("EmployeeServiceImpl :: getByDesignation() :: Ends");
        return response;
    }
    @Transactional(readOnly = true)
    public EmployeeResponse getById(Long id) {
        log.info("EmployeeServiceImpl :: getById() :: Init");
        EmployeeResponse response = employeeResponseMapper.toResponse(findEmployee(id));
        log.info("EmployeeServiceImpl :: getById() :: Ends");
        return response;
    }
    @Transactional(readOnly = true)
    public EmployeeNameResponse getNameById(Long id) {
        log.info("EmployeeServiceImpl :: getNameById() :: Init");
        EmployeeNameResponse response = employeeResponseMapper.toNameResponse(findEmployee(id));
        log.info("EmployeeServiceImpl :: getNameById() :: Ends");
        return response;
    }
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        log.info("EmployeeServiceImpl :: update() :: Init");
        Employee employee = findEmployee(id);
        employeeValidator.validateUpdatedEmail(employee, request.getEmail());
        employeeRequestMapper.convert(request, employee, findDepartment(request.getDepartmentId()), getUserName());
        EmployeeResponse response = employeeResponseMapper.toResponse(employeeDAO.save(employee));
        log.info("EmployeeServiceImpl :: update() :: Ends");
        return response;
    }
    public EmployeeResponse updateSalary(Long id, UpdateSalaryRequest request) {
        log.info("EmployeeServiceImpl :: updateSalary() :: Init");
        Employee employee = findEmployee(id);
        employee.setSalary(request.getSalary());
        employee.setUpdatedBy(getUserName());
        EmployeeResponse response = employeeResponseMapper.toResponse(employeeDAO.save(employee));
        log.info("EmployeeServiceImpl :: updateSalary() :: Ends");
        return response;
    }
    public EmployeeResponse updateStatus(Long id, UpdateStatusRequest request) {
        log.info("EmployeeServiceImpl :: updateStatus() :: Init");
        Employee employee = findEmployee(id);
        employee.setStatus(request.getStatus());
        employee.setUpdatedBy(getUserName());
        EmployeeResponse response = employeeResponseMapper.toResponse(employeeDAO.save(employee));
        log.info("EmployeeServiceImpl :: updateStatus() :: Ends");
        return response;
    }
    private Employee findEmployee(Long id) {
        return employeeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageConstants.EMPLOYEE_NOT_FOUND + id));
    }
    private Department findDepartment(Long id) {
        return departmentDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageConstants.DEPARTMENT_NOT_FOUND + id));
    }
    private String getUserName() {
        Object userName = httpRequest.getAttribute("USER_NAME");
        return userName == null ? "SYSTEM" : userName.toString();
    }
}
