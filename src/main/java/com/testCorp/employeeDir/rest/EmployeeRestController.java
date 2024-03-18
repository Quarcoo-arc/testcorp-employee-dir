package com.testCorp.employeeDir.rest;

import com.testCorp.employeeDir.entity.Employee;
import com.testCorp.employeeDir.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee with id="+ employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
        if(employee.getId() == 0){
            throw new Exception("Employee does not exist");
        }
        Employee foundEmployee = employeeService.findById(employee.getId());
        if(foundEmployee == null){
            throw new Exception("Employee with id=" + employee.getId() + " does not exist");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee with id=" + employeeId + " does not exists");
        }
        employeeService.deleteById(employeeId);
        return "Successfully deleted employee with id=" + employeeId;
    }
}
