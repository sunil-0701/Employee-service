package com.example.employeeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class DepartmentRequest {
    @NotBlank(message = "Department name is required")
    private String name;
    private String location;
}
