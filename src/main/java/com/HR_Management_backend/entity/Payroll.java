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
    private Double basicSalary;
    private Double deductions;
    private Double bonuses;
    private Double taxes;
    private Double netPay;
    private String bankAccountNumber;
    private String paymentMethod;
    private String payrollStatus;
    private Date paidOn;

    public Payroll() {
    }

    public Payroll(Integer id, Employee employee, Date payPeriodStart, Date payPeriodEnd, Double basicSalary, Double deductions, Double bonuses, Double taxes, Double netPay, String bankAccountNumber, String paymentMethod, String payrollStatus, Date paidOn) {
        this.id = id;
        this.employee = employee;
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
        this.basicSalary = basicSalary;
        this.deductions = deductions;
        this.bonuses = bonuses;
        this.taxes = taxes;
        this.netPay = netPay;
        this.bankAccountNumber = bankAccountNumber;
        this.paymentMethod = paymentMethod;
        this.payrollStatus = payrollStatus;
        this.paidOn = paidOn;
    }

    public Integer getId() {
        return id;
    }

    public Payroll setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Payroll setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public Payroll setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
        return this;
    }

    public Date getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public Payroll setPayPeriodEnd(Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
        return this;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public Payroll setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
        return this;
    }

    public Double getDeductions() {
        return deductions;
    }

    public Payroll setDeductions(Double deductions) {
        this.deductions = deductions;
        return this;
    }

    public Double getBonuses() {
        return bonuses;
    }

    public Payroll setBonuses(Double bonuses) {
        this.bonuses = bonuses;
        return this;
    }

    public Double getTaxes() {
        return taxes;
    }

    public Payroll setTaxes(Double taxes) {
        this.taxes = taxes;
        return this;
    }

    public Double getNetPay() {
        return netPay;
    }

    public Payroll setNetPay(Double netPay) {
        this.netPay = netPay;
        return this;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Payroll setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Payroll setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getPayrollStatus() {
        return payrollStatus;
    }

    public Payroll setPayrollStatus(String payrollStatus) {
        this.payrollStatus = payrollStatus;
        return this;
    }

    public Date getPaidOn() {
        return paidOn;
    }

    public Payroll setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
        return this;
    }
}