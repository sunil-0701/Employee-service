package com.example.employeeservice.dto.common;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer status;
    private StatusDetail statusDetail;
}
