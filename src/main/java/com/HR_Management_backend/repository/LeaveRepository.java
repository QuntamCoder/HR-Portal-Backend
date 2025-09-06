package com.HR_Management_backend.repository;

import com.HR_Management_backend.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
}