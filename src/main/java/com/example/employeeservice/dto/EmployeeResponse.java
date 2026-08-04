package com.example.employeeservice.dto;

import com.example.employeeservice.entity.EmployeeStatus;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
    private BigDecimal salary;
    private String designation;
    private String address;
    private EmployeeStatus status;
    private DepartmentResponse department;
}
