package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Department;
import com.HR_Management_backend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(Integer id, Department updatedDepartment) {
        return departmentRepository.findById(id)
                .map(dept -> {
                    updatedDepartment.setId(id);
                    return departmentRepository.save(updatedDepartment);
                })
                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}