package com.HR_Management_backend.repository;

import com.HR_Management_backend.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    Optional<Salary> findByEmployeeId(Integer employeeId);
}