package com.zt.spring.springboot.datajpa.springboot_data_jpa.dao;

import com.zt.spring.springboot.datajpa.springboot_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllBySalaryBetween(int s1, int s2);
}