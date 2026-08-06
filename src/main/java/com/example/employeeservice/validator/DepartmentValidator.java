package com.example.employeeservice.validator;

import com.example.employeeservice.constants.MessageConstants;
import com.example.employeeservice.dao.DepartmentDAO;
import com.example.employeeservice.entity.Department;
import com.example.employeeservice.exception.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentValidator {
    private final DepartmentDAO departmentDAO;
    public void validateNewName(String name) {
        if (departmentDAO.existsByName(name)) throw new DuplicateResourceException(MessageConstants.DEPARTMENT_NAME_EXISTS);
    }
    public void validateUpdatedName(Department department, String name) {
        if (!department.getName().equals(name) && departmentDAO.existsByName(name)) {
            throw new DuplicateResourceException(MessageConstants.DEPARTMENT_NAME_EXISTS);
        }
    }
}
