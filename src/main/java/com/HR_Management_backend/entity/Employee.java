package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private String gender;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String nationalId;
    private String passportNumber;
    private String maritalStatus;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private Date hireDate;
    private Date terminationDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String position;
    private String employmentType;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    private String status;
    private String photoUrl;
    @Column(columnDefinition = "TEXT")
    private String notes;
}