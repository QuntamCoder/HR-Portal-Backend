package com.HR_Management_backend.repository;

import com.HR_Management_backend.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
    List<Payroll> findByEmployeeId(Integer employeeId);
}