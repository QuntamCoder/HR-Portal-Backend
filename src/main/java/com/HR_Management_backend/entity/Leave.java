package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}