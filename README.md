# Module 5: Collections and Generics

## Objective
The objective of this module is to get hands-on experience with the following topics:
1. Introduction to Collection Framework
2. Working with Set
3. Working with List
4. Working with Map
5. Working with Generics

# Lab 5.3

## Objectives
1. Understand and implement `Map` in Java.

## Problem Statement
Create a `Map` of `Employees` with `empId` as the key and `Employee` object as the value, and iterate through the `Map`.

### Tasks
1. **Create the following property** under the `EmployeeRepository` class:
    ```java
    Map<Integer, Employee> employeeMap;
    ```

2. **Inside the no-argument constructor**, perform the following steps:
   - Initialize `employeeMap` to `HashMap`.
   - Add all `Employee` objects, `Developer` objects, and `Designer` objects to `employeeMap`, mapping their `empId` as the key and the object as the value.
   - Add one duplicate `Employee`/`Developer`/`Designer` object to `employeeMap`.

3. **Create the following method** in `EmployeeRepository` that returns the `Map<Integer, Employee>`:
    ```java
    public Map<Integer, Employee> getEmployeeMap()
    ```

4. **In the `CollectionTest` class**, get the `Employee` map by calling `getEmployeeMap()` method.

5. **Print the total number of employees**.

6. **Run the `CollectionTest` class** and observe that it will print "No of Employees: 6" since we have added one duplicate key. 
   - *Note: `Map` doesn't allow duplicate keys but will allow duplicate values.*

7. **Iterate through `employeeMap`** and display each `Employee` profile by calling `displayProfile(Employee)` on the `PayrollImpl` object.
