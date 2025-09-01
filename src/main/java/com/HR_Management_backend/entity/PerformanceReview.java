package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Employee reviewer;

    private Date reviewDate;
    private String reviewPeriod;
    private Integer score;
    private String overallRating;

    @Column(columnDefinition = "TEXT")
    private String goals;

    @Column(columnDefinition = "TEXT")
    private String improvementPlan;

    @Column(columnDefinition = "TEXT")
    private String comments;
}