package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Employee;
import com.HR_Management_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read by id
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    // Update
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    updatedEmployee.setId(id);
                    return employeeRepository.save(updatedEmployee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    // Delete
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}