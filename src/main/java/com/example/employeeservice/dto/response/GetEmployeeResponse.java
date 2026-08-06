package com.example.employeeservice.dto.response;

import com.example.employeeservice.dto.common.BaseResponse;
import com.example.employeeservice.dto.common.Meta;
import lombok.*;
import java.util.List;

@Data @EqualsAndHashCode(callSuper = true)
public class GetEmployeeResponse extends BaseResponse {
    private List<EmployeeResponse> data;
    private Meta meta;
}
