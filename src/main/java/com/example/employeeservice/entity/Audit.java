package com.example.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Audit {
    @Column(updatable = false)
    private String createdBy;
    private String updatedBy;
}
