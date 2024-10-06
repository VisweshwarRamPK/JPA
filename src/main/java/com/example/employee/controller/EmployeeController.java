package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Fetching all employees");
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        logger.info("Fetching employee with id: {}", id);
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        logger.info("Creating new employee: {}", employee);
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        logger.info("Updating employee with id: {}", id);
        Employee updatedEmployee = employeeService.update(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        logger.info("Deleting employee with id: {}", id);
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
