package com.HR_Management_backend.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(columnDefinition = "TEXT")
    private String remarks;

    private Date date;
    private java.sql.Time checkIn;
    private java.sql.Time checkOut;
    private Double workedHours;
    private Boolean isLate;
    private String status;

    public Attendance() {
    }

    public Attendance(Integer id, Employee employee, Date date, Time checkIn, Time checkOut, Double workedHours, Boolean isLate, String status, String remarks) {
        this.id = id;
        this.employee = employee;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.workedHours = workedHours;
        this.isLate = isLate;
        this.status = status;
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public Attendance setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Attendance setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Attendance setDate(Date date) {
        this.date = date;
        return this;
    }

    public Time getCheckIn() {
        return checkIn;
    }

    public Attendance setCheckIn(Time checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public Time getCheckOut() {
        return checkOut;
    }

    public Attendance setCheckOut(Time checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public Attendance setWorkedHours(Double workedHours) {
        this.workedHours = workedHours;
        return this;
    }

    public Boolean getLate() {
        return isLate;
    }

    public Attendance setLate(Boolean late) {
        isLate = late;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Attendance setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Attendance setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

}