package com.HR_Management_backend.entity;

import jakarta.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;

    // Monthly basic salary
    private Double basicSalary;

    public Salary() {}

    public Salary(Integer id, Employee employee, Double basicSalary) {
        this.id = id;
        this.employee = employee;
        this.basicSalary = basicSalary;
    }

    public Integer getId() {
        return id;
    }

    public Salary setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Salary setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public Salary setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
        return this;
    }
}