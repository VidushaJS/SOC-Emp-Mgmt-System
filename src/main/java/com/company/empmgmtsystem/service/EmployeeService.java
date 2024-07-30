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


    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }


    public Employee updateEmployee(int id, Employee employee) {

        Employee emp = employeeRepository.findById(id).orElse(null);

        if (emp != null) {
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setSalary(employee.getSalary());
            emp.setPosition(employee.getPosition());

            return saveEmployee(emp);
        }
        return null;
    }


    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }


}
