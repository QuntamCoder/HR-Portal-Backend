package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date payPeriodStart;
    private Date payPeriodEnd;
    private Double basicSalary;
    private Double deductions;
    private Double bonuses;
    private Double taxes;
    private Double netPay;
    private String bankAccountNumber;
    private String paymentMethod;
    private String payrollStatus;
    private Date paidOn;
}