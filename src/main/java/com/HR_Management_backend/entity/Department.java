package com.HR_Management_backend.entity;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_id")
    private Employee head;

    private String description;

    public Department() {
    }

    public Department(Integer id, String name, String description, Employee head) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.head = head;
    }

    public Integer getId() {
        return id;
    }

    public Department setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Employee getHead() {
        return head;
    }

    public Department setHead(Employee head) {
        this.head = head;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Department setDescription(String description) {
        this.description = description;
        return this;
    }
}