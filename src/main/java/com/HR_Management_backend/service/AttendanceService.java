package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Attendance;
import com.HR_Management_backend.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByDate(Date date) {
        return attendanceRepository.findByDate(date);
    }

    public List<Attendance> getAttendanceByEmployeeAndDate(Integer employeeId, Date date) {
        return attendanceRepository.findByEmployeeIdAndDate(employeeId, date);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Integer id) {
        return attendanceRepository.findById(id);
    }
}