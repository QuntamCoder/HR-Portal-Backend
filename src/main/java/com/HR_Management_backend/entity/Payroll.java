package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date payPeriodStart;
    private Date payPeriodEnd;
    private Integer presentDays;
    private Double basicSalary;
    private Double grossPay;
    private Double netPay;
    private String payrollStatus;
    private Date paidOn;

    public Payroll() {}

    public Payroll(Integer id, Employee employee, Date payPeriodStart, Date payPeriodEnd, Integer presentDays, Double basicSalary, Double grossPay, Double netPay, String payrollStatus, Date paidOn) {
        this.id = id;
        this.employee = employee;
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
        this.presentDays = presentDays;
        this.basicSalary = basicSalary;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.payrollStatus = payrollStatus;
        this.paidOn = paidOn;
    }

    // Getters and setters for all fields...
    public Integer getId() { return id; }
    public Payroll setId(Integer id) { this.id = id; return this; }
    public Employee getEmployee() { return employee; }
    public Payroll setEmployee(Employee employee) { this.employee = employee; return this; }
    public Date getPayPeriodStart() { return payPeriodStart; }
    public Payroll setPayPeriodStart(Date payPeriodStart) { this.payPeriodStart = payPeriodStart; return this; }
    public Date getPayPeriodEnd() { return payPeriodEnd; }
    public Payroll setPayPeriodEnd(Date payPeriodEnd) { this.payPeriodEnd = payPeriodEnd; return this; }
    public Integer getPresentDays() { return presentDays; }
    public Payroll setPresentDays(Integer presentDays) { this.presentDays = presentDays; return this; }
    public Double getBasicSalary() { return basicSalary; }
    public Payroll setBasicSalary(Double basicSalary) { this.basicSalary = basicSalary; return this; }
    public Double getGrossPay() { return grossPay; }
    public Payroll setGrossPay(Double grossPay) { this.grossPay = grossPay; return this; }
    public Double getNetPay() { return netPay; }
    public Payroll setNetPay(Double netPay) { this.netPay = netPay; return this; }
    public String getPayrollStatus() { return payrollStatus; }
    public Payroll setPayrollStatus(String payrollStatus) { this.payrollStatus = payrollStatus; return this; }
    public Date getPaidOn() { return paidOn; }
    public Payroll setPaidOn(Date paidOn) { this.paidOn = paidOn; return this; }
}