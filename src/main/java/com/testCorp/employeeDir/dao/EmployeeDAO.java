package com.testCorp.employeeDir.dao;

import com.testCorp.employeeDir.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
