package com.example.employeeservice.dto.response;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class DepartmentResponse {
    private Long id;
    private String name;
    private String location;
}
