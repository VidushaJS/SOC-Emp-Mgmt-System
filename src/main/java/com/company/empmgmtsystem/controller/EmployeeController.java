package com.company.empmgmtsystem.controller;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")        //Base URL
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping                    //Maps to json and returns
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) {         // Maps json coming from the body to an Employee object
        return employeeService.saveEmployee(employee);      // Returns the created employee as a http response
    }


    @PutMapping("/{id}")                            //PutMapping is used for updates
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
    // Eventhough the PutMapping and DeleteMapping parameters are same they are distinguished by request type

}
