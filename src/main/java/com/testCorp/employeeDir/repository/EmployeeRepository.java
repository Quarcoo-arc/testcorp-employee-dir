package com.testCorp.employeeDir.repository;

import com.testCorp.employeeDir.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
    The annotation below is used to alter the base path for the entity
    By default the path is the entity name with an 's' attached to it.

*/
@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
