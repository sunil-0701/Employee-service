package com.example.employeeservice.dto;

import com.example.employeeservice.entity.EmployeeStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusRequest {
    @NotNull(message = "Status is required")
    private EmployeeStatus status;
}
