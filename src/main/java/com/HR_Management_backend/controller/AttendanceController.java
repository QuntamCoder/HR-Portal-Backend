package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Attendance;
import com.HR_Management_backend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    // Create or update daily attendance
    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    // Get all attendance for selected date
    @GetMapping("/date")
    public List<Attendance> getAttendanceByDate(@RequestParam("date") long dateMillis) {
        Date date = new Date(dateMillis);
        return attendanceService.getAttendanceByDate(date);
    }

    // Get all attendance (optional)
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
}