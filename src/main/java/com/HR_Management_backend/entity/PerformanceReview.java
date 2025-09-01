package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
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

    public PerformanceReview() {
    }

    public PerformanceReview(Integer id, Employee employee, Employee reviewer, Date reviewDate, String reviewPeriod, Integer score, String overallRating, String goals, String improvementPlan, String comments) {
        this.id = id;
        this.employee = employee;
        this.reviewer = reviewer;
        this.reviewDate = reviewDate;
        this.reviewPeriod = reviewPeriod;
        this.score = score;
        this.overallRating = overallRating;
        this.goals = goals;
        this.improvementPlan = improvementPlan;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public PerformanceReview setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public PerformanceReview setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Employee getReviewer() {
        return reviewer;
    }

    public PerformanceReview setReviewer(Employee reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public PerformanceReview setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
        return this;
    }

    public String getReviewPeriod() {
        return reviewPeriod;
    }

    public PerformanceReview setReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public PerformanceReview setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public PerformanceReview setOverallRating(String overallRating) {
        this.overallRating = overallRating;
        return this;
    }

    public String getGoals() {
        return goals;
    }

    public PerformanceReview setGoals(String goals) {
        this.goals = goals;
        return this;
    }

    public String getImprovementPlan() {
        return improvementPlan;
    }

    public PerformanceReview setImprovementPlan(String improvementPlan) {
        this.improvementPlan = improvementPlan;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public PerformanceReview setComments(String comments) {
        this.comments = comments;
        return this;
    }
}