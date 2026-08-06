package com.example.employeeservice.dto.response;

import com.example.employeeservice.enums.EmployeeStatus;
import com.example.employeeservice.dto.common.BaseResponse;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class EmployeeResponse extends BaseResponse {
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
    private EmployeeStatus employeeStatus;
    private DepartmentResponse department;
}
