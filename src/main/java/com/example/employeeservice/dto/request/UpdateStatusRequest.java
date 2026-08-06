package com.example.employeeservice.dto.request;

import com.example.employeeservice.enums.EmployeeStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class UpdateStatusRequest {
    @NotNull(message = "Status is required")
    private EmployeeStatus status;
}
