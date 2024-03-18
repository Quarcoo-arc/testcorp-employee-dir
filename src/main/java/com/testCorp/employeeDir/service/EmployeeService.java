package com.testCorp.employeeDir.service;

import com.testCorp.employeeDir.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();

    public Optional<Employee> findById(Integer id);

    public Employee save(Employee employee);

    public void deleteById(Integer id);
}
