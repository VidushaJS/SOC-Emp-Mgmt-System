package com.company.empmgmtsystem.service;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


}
