package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date date;
    private java.sql.Time checkIn;
    private java.sql.Time checkOut;
    private Double workedHours;
    private Boolean isLate;
    private String status;

    @Column(columnDefinition = "TEXT")
    private String remarks;
}