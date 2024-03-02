package com.testCorp.employeeDir.rest;

import com.testCorp.employeeDir.dao.EmployeeDAO;
import com.testCorp.employeeDir.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
