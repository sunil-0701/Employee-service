package com.example.employeeservice.validator;

import com.example.employeeservice.constants.MessageConstants;
import com.example.employeeservice.dao.EmployeeDAO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeValidator {
    private final EmployeeDAO employeeDAO;
    public void validateNewEmail(String email) {
        if (employeeDAO.findByEmail(email).isPresent()) throw new DuplicateResourceException(MessageConstants.EMAIL_EXISTS);
    }
    public void validateUpdatedEmail(Employee employee, String email) {
        if (!employee.getEmail().equals(email) && employeeDAO.findByEmail(email).isPresent()) {
            throw new DuplicateResourceException(MessageConstants.EMAIL_EXISTS);
        }
    }
}
