package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Salary;
import com.HR_Management_backend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public Salary saveOrUpdateSalary(Salary salary) {
        Optional<Salary> existing = salaryRepository.findByEmployeeId(salary.getEmployee().getId());
        if (existing.isPresent()) {
            Salary s = existing.get();
            s.setBasicSalary(salary.getBasicSalary());
            return salaryRepository.save(s);
        }
        return salaryRepository.save(salary);
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Optional<Salary> getSalaryById(Integer id) {
        return salaryRepository.findById(id);
    }

    public Optional<Salary> getSalaryByEmployeeId(Integer employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }

    public void deleteSalary(Integer id) {
        salaryRepository.deleteById(id);
    }
}