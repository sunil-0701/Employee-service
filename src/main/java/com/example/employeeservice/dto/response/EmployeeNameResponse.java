package com.example.employeeservice.dto.response;

import lombok.*;
import com.example.employeeservice.dto.common.BaseResponse;

@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class EmployeeNameResponse extends BaseResponse {
    private Long id;
    private String fullName;
}
