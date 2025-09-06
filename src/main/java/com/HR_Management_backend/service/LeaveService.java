package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Leave;
import com.HR_Management_backend.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public Leave applyLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Integer id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public void deleteLeave(Integer id) {
        leaveRepository.deleteById(id);
    }
}