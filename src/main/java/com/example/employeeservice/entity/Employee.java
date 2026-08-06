package com.example.employeeservice.entity;

import jakarta.persistence.*;
import com.example.employeeservice.enums.EmployeeStatus;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Employee extends Audit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    @Column(nullable = false, unique = true) private String email;
    private String phoneNumber;
    @Column(nullable = false) private LocalDate dateOfBirth;
    @Column(nullable = false) private LocalDate joinDate;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal salary;
    private String designation;
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Department department;
}
