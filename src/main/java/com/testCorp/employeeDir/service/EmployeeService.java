package com.testCorp.employeeDir.service;

import com.testCorp.employeeDir.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee save(Employee employee);

    public void deleteById(Integer id);
}
