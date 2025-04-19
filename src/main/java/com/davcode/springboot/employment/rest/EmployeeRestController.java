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


    /**
     * Handles GET requests to retrieve a specific employee by ID.
     *
     * @param employeeId The ID of the employee to retrieve.
     */
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


    /**
     * Handles POST requests to add a new employee.
     *
     * @param employee The employee object to add.
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        // Set the ID to 0 to ensure a new employee is created
        employee.setId(0);
        return employeeService.save(employee);
    }


    /**
     * Handles PUT requests to update an existing employee.
     *
     * @param employee The employee object with updated data.
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }


    /**
     * Handles PATCH requests to partially update an existing employee.
     *
     * @param employeeId  The ID of the employee to update.
     * @param patchPayLoad The JSON payload containing the fields to update.
     */
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


    /**
     * Applies a patch to an existing employee object.
     *
     * @param patchPayLoad  The JSON payload containing the fields to update.
     * @param existingEmployee  The existing employee object to be updated.
     * @return The updated employee object.
     */
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


    /**
     * Handles DELETE requests to remove an employee by ID.
     *
     * @param employeeId The ID of the employee to delete.
     */
    @DeleteMapping("employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
        {
            throw new RuntimeException("The employee id was not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
    }
}
