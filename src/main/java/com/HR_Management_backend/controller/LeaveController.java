package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Leave;
import com.HR_Management_backend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public Leave applyLeave(@RequestBody Leave leave) {
        return leaveService.applyLeave(leave);
    }

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Integer id) {
        return leaveService.getLeaveById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Integer id) {
        leaveService.deleteLeave(id);
    }
}