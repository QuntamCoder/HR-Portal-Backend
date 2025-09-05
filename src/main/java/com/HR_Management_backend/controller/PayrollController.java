package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Payroll;
import com.HR_Management_backend.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // Auto generate payroll for employee and period
    @PostMapping("/generate")
    public Payroll generatePayroll(@RequestParam Integer employeeId,
                                   @RequestParam Long payPeriodStart,
                                   @RequestParam Long payPeriodEnd) {
        return payrollService.generatePayroll(employeeId, new Date(payPeriodStart), new Date(payPeriodEnd));
    }

    // Get all payrolls
    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    // Get payrolls by employee
    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getPayrollsByEmployee(@PathVariable Integer employeeId) {
        return payrollService.getPayrollsByEmployeeId(employeeId);
    }
}