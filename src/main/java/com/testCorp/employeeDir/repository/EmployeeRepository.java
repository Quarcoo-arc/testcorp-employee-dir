package com.testCorp.employeeDir.repository;

import com.testCorp.employeeDir.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
