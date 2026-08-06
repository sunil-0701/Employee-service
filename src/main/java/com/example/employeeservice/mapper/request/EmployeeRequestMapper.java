package com.example.employeeservice.mapper.request;

import com.example.employeeservice.dto.request.EmployeeRequest;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequestMapper {
    public Employee convert(EmployeeRequest request, Department department, String userName) {
        Employee employee = new Employee();
        convert(request, employee, department, userName);
        employee.setCreatedBy(userName);
        return employee;
    }
    public void convert(EmployeeRequest request, Employee employee, Department department, String userName) {
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setJoinDate(request.getJoinDate());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setAddress(request.getAddress());
        employee.setDepartment(department);
        employee.setUpdatedBy(userName);
    }
}
