package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Salary;
import com.HR_Management_backend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
@CrossOrigin
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping
    public Salary saveOrUpdateSalary(@RequestBody Salary salary) {
        return salaryService.saveOrUpdateSalary(salary);
    }

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public Optional<Salary> getSalaryById(@PathVariable Integer id) {
        return salaryService.getSalaryById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public Optional<Salary> getSalaryByEmployeeId(@PathVariable Integer employeeId) {
        return salaryService.getSalaryByEmployeeId(employeeId);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Integer id) {
        salaryService.deleteSalary(id);
    }
}