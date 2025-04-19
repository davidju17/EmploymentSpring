package com.davcode.springboot.employment.service;

import com.davcode.springboot.employment.entity.Employee;

import java.util.List;

/**
 * The EmployeeService interface provides methods for managing employee data.
 */
public interface EmployeeService
{

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees.
     */
    List<Employee> findAll();

    /**
     * Saves a new employee.
     *
     * @param employee the employee to save.
     */
    Employee save(Employee employee);

    /**
     * Retrieves an employee by their unique identifier.
     *
     * @param id the unique identifier of the employee.
     * @return the employee with the specified identifier, or null if not found.
     */
    Employee findById(int id);

    /**
     * Deletes an employee by their unique identifier.
     *
     * @param id the unique identifier of the employee to delete.
     */
    void deleteById(int id);
}
