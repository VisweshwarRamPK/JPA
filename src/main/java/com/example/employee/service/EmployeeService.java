package com.example.employee.service;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
        logger.info("Retrieving all employees");
        return employeeRepository.findAll();
    }

    public Employee findById(String id) {
        logger.info("Searching for employee with id: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Employee with id: {} not found", id);
                    return new EmployeeNotFoundException(id);
                });
    }

    public Employee save(Employee employee) {
        logger.info("Saving employee: {}", employee);
        return employeeRepository.save(employee);
    }


    public Employee update(String id, Employee employee) {
        logger.info("Updating employee with id: {}", id);
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    employee.setId(id); // Set the employee ID for update
                    logger.info("Employee updated with id: {}", id);
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> {
                    logger.error("Employee with id: {} not found for update", id);
                    return new EmployeeNotFoundException(id);
                });
    }


    public void delete(String id) {
        logger.info("Deleting employee with id: {}", id);
        employeeRepository.findById(id)
                .ifPresentOrElse(
                        existingEmployee -> {
                            logger.info("Employee found. Deleting employee with id: {}", id);
                            employeeRepository.deleteById(id);
                        },
                        () -> {
                            logger.error("Employee with id: {} not found for deletion", id);
                            throw new EmployeeNotFoundException(id);
                        }
                );
    }
}
