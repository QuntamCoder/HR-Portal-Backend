package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity

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


    public Employee() {
    }

    public Employee(Integer id, String firstName, String middleName, String lastName, Date dob, String gender, String email, String phone, String address, String nationalId, String passportNumber, String maritalStatus, String emergencyContactName, String emergencyContactPhone, Date hireDate, Date terminationDate, Department department, Team team, String position, String employmentType, Employee manager, String status, String photoUrl, String notes) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nationalId = nationalId;
        this.passportNumber = passportNumber;
        this.maritalStatus = maritalStatus;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.hireDate = hireDate;
        this.terminationDate = terminationDate;
        this.department = department;
        this.team = team;
        this.position = position;
        this.employmentType = employmentType;
        this.manager = manager;
        this.status = status;
        this.photoUrl = photoUrl;
        this.notes = notes;
    }

    public Employee(Integer employeeId) {
    }



    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Employee setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public Employee setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Employee setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public Employee setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Employee setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Employee setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public Employee setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public Employee setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public Employee setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Employee setTeam(Team team) {
        this.team = team;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public Employee setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public Employee getManager() {
        return manager;
    }

    public Employee setManager(Employee manager) {
        this.manager = manager;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Employee setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Employee setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Employee setNotes(String notes) {
        this.notes = notes;
        return this;
    }
}