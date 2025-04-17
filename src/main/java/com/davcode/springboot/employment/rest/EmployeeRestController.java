package com.davcode.springboot.employment.rest;

import com.davcode.springboot.employment.entity.Employee;
import com.davcode.springboot.employment.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for handling employee-related API requests.
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController
{

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    /**
     * Constructor for EmployeeRestController.
     *
     * @param employeeService The service used to manage employee data.
     * @param objectMapper    The ObjectMapper used for JSON serialization/deserialization.
     */
    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper)
    {
        // Use constructor injection for better testability
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
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


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
        {
            throw new RuntimeException("The employee id was not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        // Set the ID to 0 to ensure a new employee is created
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad)
    {
        Employee existingEmployee = employeeService.findById(employeeId);

        if(existingEmployee == null)
        {
            throw new RuntimeException("The employee id was not found - " + employeeId);
        }

        if(patchPayLoad.containsKey("id"))
        {
            throw new RuntimeException("The employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayLoad, existingEmployee);

        return employeeService.save(patchedEmployee);
    }


    public Employee apply(Map<String, Object> patchPayLoad, Employee existingEmployee)
    {
        // Convert existing employee to a JSON ObjectNode
        ObjectNode employeeNode = objectMapper.convertValue(existingEmployee, ObjectNode.class);
        // Convert patchPayload to a JSON ObjectNode
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        // Merge the patchUpate into the employeeNode
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

}
