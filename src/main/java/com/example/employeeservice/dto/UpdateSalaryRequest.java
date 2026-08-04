package com.example.employeeservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSalaryRequest {
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private BigDecimal salary;
}
