package com.example.employeeservice.dto.common;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class Meta {
    private int currentPage;
    private int perPage;
    private long totalCount;
    private int totalPages;
}
