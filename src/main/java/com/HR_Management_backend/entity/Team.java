package com.HR_Management_backend.entity;

import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Employee lead;

    public Team() {
    }

    public Team(Integer id, String name, String description, Employee lead) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lead = lead;
    }

    public Integer getId() {
        return id;
    }

    public Team setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Team setDescription(String description) {
        this.description = description;
        return this;
    }

    public Employee getLead() {
        return lead;
    }

    public Team setLead(Employee lead) {
        this.lead = lead;
        return this;
    }
}