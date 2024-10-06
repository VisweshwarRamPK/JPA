package com.example.employee.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("1", "John Doe", "Engineering", 75000.00);
    }

    @Test
    public void testEmployeeConstructorAndGetters() {

        assertEquals("1", employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals("Engineering", employee.getDepartment());
        assertEquals(75000.00, employee.getSalary());
    }

    @Test
    public void testDefaultConstructor() {

        Employee defaultEmployee = new Employee();

        // Check that the default values are null or 0.0
        assertNull(defaultEmployee.getId());
        assertNull(defaultEmployee.getName());
        assertNull(defaultEmployee.getDepartment());
        assertEquals(0.0, defaultEmployee.getSalary());
    }

    @Test
    public void testSetters() {

        employee.setId("2");
        employee.setName("Jane Doe");
        employee.setDepartment("HR");
        employee.setSalary(85000.00);


        assertEquals("2", employee.getId());
        assertEquals("Jane Doe", employee.getName());
        assertEquals("HR", employee.getDepartment());
        assertEquals(85000.00, employee.getSalary());
    }
}
