package com.davcode.springboot.employment.rest;

import com.davcode.springboot.employment.dao.EmployeeDAO;
import com.davcode.springboot.employment.entity.Employee;
import com.davcode.springboot.employment.service.EmployeeService;
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

    private EmployeeService employeeService;

    /**
     * Constructor for EmployeeRestController.
     *
     * @param employeeService The service used to manage employee data.
     */
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    /**
     * Handles GET requests to retrieve a list of all employees.
     *
     * @return A list of Employee objects.
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.findAll();
    }
}
