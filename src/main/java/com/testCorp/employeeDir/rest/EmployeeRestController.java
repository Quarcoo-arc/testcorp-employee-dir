package com.testCorp.employeeDir.rest;

import com.testCorp.employeeDir.entity.Employee;
import com.testCorp.employeeDir.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if(employee.isEmpty()) {
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
        Optional<Employee> foundEmployee = employeeService.findById(employee.getId());
        if(foundEmployee.isEmpty()){
            throw new Exception("Employee with id=" + employee.getId() + " does not exist");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
        if(employee.isEmpty()){
            throw new RuntimeException("Employee with id=" + employeeId + " does not exists");
        }
        employeeService.deleteById(employeeId);
        return "Successfully deleted employee with id=" + employeeId;
    }
}
