package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    private Date startDate;
    private Date endDate;
    private Integer leaveDays;

    @Column(columnDefinition = "TEXT")
    private String reason;

    private String documentUrl;
    private String status;
    private Date appliedOn;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;

    @Column(columnDefinition = "TEXT")
    private String rejectionReason;

    public Leave() {
    }

    public Leave(Integer id, Employee employee, LeaveType leaveType, Date startDate, Date endDate, Integer leaveDays, String reason, String documentUrl, String status, Date appliedOn, Employee approvedBy, String rejectionReason) {
        this.id = id;
        this.employee = employee;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveDays = leaveDays;
        this.reason = reason;
        this.documentUrl = documentUrl;
        this.status = status;
        this.appliedOn = appliedOn;
        this.approvedBy = approvedBy;
        this.rejectionReason = rejectionReason;
    }
}