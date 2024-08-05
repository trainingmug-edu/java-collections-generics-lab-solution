package com.trainingmug.ecommerce.main;

import com.trainingmug.ecommerce.domain.Employee;
import com.trainingmug.ecommerce.repository.EmployeeRepository;
import com.trainingmug.ecommerce.service.PayrollImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTestTest {

    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = new EmployeeRepository();
    }

    @Test
    @Order(1)
    @DisplayName("Check if getEmployeeMap() method is declared")
    void testGetEmployeeMapDeclaration() {
        try {
            EmployeeRepository.class.getMethod("getEmployeeMap");
        } catch (NoSuchMethodException e) {
            fail("Method getEmployeeMap() should be declared");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check if getEmployeeMap() method works properly")
    void testGetEmployeeMapWorking() {
        Map<Integer, Employee> employeeMap = employeeRepository.getEmployeeMap();

        // Check that the map is not null
        assertNotNull(employeeMap, "getEmployeeMap() should not return null");

        // Check that the map contains the expected number of entries (6 unique entries expected)
        assertEquals(6, employeeMap.size(), "getEmployeeMap() should return a map of size 6");

        // Check if specific entries are present by their keys and verify some attributes
        Employee employee1 = employeeMap.get(3333);
        assertNotNull(employee1, "Employee with key 3333 should not be null");
        assertEquals("Nancy Davolio", employee1.getName(), "Name should be 'Nancy Davolio' for key 3333");

        Employee employee2 = employeeMap.get(4444);
        assertNotNull(employee2, "Employee with key 4444 should not be null");
        assertEquals("Steven Buchanan", employee2.getName(), "Name should be 'Steven Buchanan' for key 4444");
    }
}
