package com.company.empmgmtsystem.service;


import com.company.empmgmtsystem.model.Department;
import com.company.empmgmtsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(long id, Department department) {
        Department dpt = departmentRepository.findById(id).orElse(null);

        if (dpt != null) {
            dpt.setName(department.getName());
            return saveDepartment(dpt);
        }
        return null;
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }

}
