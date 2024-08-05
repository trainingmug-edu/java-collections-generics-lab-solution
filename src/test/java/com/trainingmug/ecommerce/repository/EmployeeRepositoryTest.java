package com.trainingmug.ecommerce.repository;

import com.trainingmug.ecommerce.domain.Employee;
import com.trainingmug.ecommerce.domain.Designer;
import com.trainingmug.ecommerce.domain.Developer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        // Initializing the EmployeeRepository before each test
        employeeRepository = new EmployeeRepository();
    }

    @Test
    @Order(1)
    @DisplayName("Check if employeeMap field is declared")
    void testEmployeeMapDeclaration() {
        // Check if the employeeMap field is declared
        try {
            EmployeeRepository.class.getDeclaredField("employeeMap");
        } catch (NoSuchFieldException e) {
            fail("employeeMap field should be declared");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check employeeMap initialization and contents in the no-arg constructor")
    void testEmployeeMapInitialization() {
        Map<Integer, Employee> employeeMap = employeeRepository.getEmployeeMap();

        // Verify that employeeMap is initialized
        assertNotNull(employeeMap, "employeeMap should be initialized");

        // Check if employeeMap is an instance of HashMap
        assertTrue(employeeMap instanceof HashMap, "employeeMap should be an instance of HashMap");

        // Check the size of the map (expecting 6 unique keys due to duplicate removal)
        assertEquals(6, employeeMap.size(), "employeeMap size should be 6");

        // Check if specific entries are present by their keys
        assertTrue(employeeMap.containsKey(3333), "employeeMap should contain key 3333");
        assertTrue(employeeMap.containsKey(4444), "employeeMap should contain key 4444");
        assertTrue(employeeMap.containsKey(5555), "employeeMap should contain key 5555");
        assertTrue(employeeMap.containsKey(6666), "employeeMap should contain key 6666");
        assertTrue(employeeMap.containsKey(7777), "employeeMap should contain key 7777");
        assertTrue(employeeMap.containsKey(8888), "employeeMap should contain key 8888");

        // Check if the duplicate entry has been handled (only one entry for the duplicate key)
        Employee duplicateEmployee = employeeMap.get(8888);
        assertNotNull(duplicateEmployee, "The employee with key 8888 should not be null");
        assertEquals("Daniel Faviet", duplicateEmployee.getName(),
                "The name should be 'Daniel Faviet' for the employee with key 8888");
    }

    @Test
    @Order(3)
    @DisplayName("Check if getEmployeeMap() method returns the correct map")
    void testGetEmployeeMap() {
        Map<Integer, Employee> employeeMap = employeeRepository.getEmployeeMap();

        // Verify that getEmployeeMap() returns the correct map
        assertNotNull(employeeMap, "getEmployeeMap() should return a non-null map");
        assertEquals(6, employeeMap.size(), "getEmployeeMap() should return a map of size 6");
    }
}
