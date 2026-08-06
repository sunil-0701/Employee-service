package com.example.employeeservice.mapper.response;

import com.example.employeeservice.dto.response.*;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.util.NameUtils;
import com.example.employeeservice.constants.*;
import com.example.employeeservice.dto.common.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeResponseMapper {
    private final DepartmentResponseMapper departmentResponseMapper;
    public EmployeeResponse toResponse(Employee employee) {
        Department department = employee.getDepartment();
        EmployeeResponse response = new EmployeeResponse(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getDateOfBirth(), employee.getJoinDate(), employee.getSalary(),
                employee.getDesignation(), employee.getAddress(), employee.getStatus(), departmentResponseMapper.toResponse(department));
        setSuccess(response);
        return response;
    }
    public EmployeeNameResponse toNameResponse(Employee employee) {
        EmployeeNameResponse response = new EmployeeNameResponse(employee.getId(), NameUtils.fullName(employee.getFirstName(), employee.getLastName()));
        setSuccess(response);
        return response;
    }
    public void setSuccess(BaseResponse response) {
        response.setStatus(ResponseStatusConstants.SUCCESS);
        response.setStatusDetail(new StatusDetail(ResponseStatusConstants.SUCCESS_STATUS, MessageConstants.SUCCESS_DESC));
    }
}
