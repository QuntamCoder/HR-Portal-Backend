package com.HR_Management_backend.repository;

import com.HR_Management_backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByDate(Date date);
    List<Attendance> findByEmployeeIdAndDate(Integer employeeId, Date date);

    List<Attendance> findByEmployeeIdAndDateBetween(Integer employeeId, Date start, Date end);
}