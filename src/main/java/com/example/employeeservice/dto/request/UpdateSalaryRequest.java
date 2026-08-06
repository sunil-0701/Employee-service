package com.example.employeeservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class UpdateSalaryRequest {
    @NotNull(message = "Salary is required") @Positive(message = "Salary must be positive")
    private BigDecimal salary;
}
