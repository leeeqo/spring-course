package com.zt.spring.springboot.datajpa.springboot_data_jpa.service;

import com.zt.spring.springboot.datajpa.springboot_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> findAllBySalaryBetween(int s1, int s2);
}
