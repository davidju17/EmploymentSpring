package com.davcode.springboot.employment.rest;

import com.davcode.springboot.employment.dao.EmployeeDAO;
import com.davcode.springboot.employment.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling employee-related API requests.
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController
{

    private EmployeeDAO employeeDAO;

    /**
     * Constructor for injecting the EmployeeDAO dependency.
     *
     * @param employeeDAO Data Access Object for Employee entities.
     */
    public EmployeeRestController(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    /**
     * Handles GET requests to retrieve a list of all employees.
     *
     * @return A list of Employee objects.
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeDAO.findAll();
    }

}
