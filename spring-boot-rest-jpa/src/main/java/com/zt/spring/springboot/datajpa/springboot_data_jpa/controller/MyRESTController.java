package com.zt.spring.springboot.datajpa.springboot_data_jpa.controller;


import com.zt.spring.springboot.datajpa.springboot_data_jpa.entity.Employee;
import com.zt.spring.springboot.datajpa.springboot_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("/employees/salary/between/{salary1}/{salary2}")
    public List<Employee> showAllEmployeesBySalaryBetween(
            @PathVariable int salary1, @PathVariable int salary2) {

        List<Employee> employees = employeeService.findAllBySalaryBetween(salary1, salary2);
        return employees;
    }
}
