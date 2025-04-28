package com.davcode.springboot.employment.controller;

import com.davcode.springboot.employment.dao.EmployeeRepository;
import com.davcode.springboot.employment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing employee-related operations.
 * Provides methods for listing, adding, updating, and deleting employees.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private final EmployeeRepository employeeRepository;


    /**
     * Constructor to inject the EmployeeRepository dependency.
     *
     * @param employeeRepository Repository for accessing employee data.
     */
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }


    /**
     * Handles GET requests to list all employees.
     * Retrieves employees ordered by last name and adds them to the model.
     *
     * @param model The model to pass data to the view.
     * @return The name of the Thymeleaf template for listing employees.
     */
    @GetMapping("/list")
    public String listEmployees(Model model)
    {
        List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();

        // Add the list of employees to the model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }


    /**
     * Handles GET requests to show the form for adding a new employee.
     * Adds an empty Employee object to the model.
     *
     * @param model The model to pass data to the view.
     * @return The name of the Thymeleaf template for the employee form.
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }


    /**
     * Handles GET requests to show the form for updating an existing employee.
     * Retrieves the employee by ID and adds it to the model.
     *
     * @param id The ID of the employee to update.
     * @param model The model to pass data to the view.
     * @return The name of the Thymeleaf template for the employee form.
     * @throws RuntimeException If the employee with the given ID is not found.
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,Model model)
    {
        Optional<Employee> optionalEmployeeById = employeeRepository.findById(id);

        Employee employee = optionalEmployeeById.orElseThrow(() -> new RuntimeException("Employee not found"));

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }


    /**
     * Handles POST requests to save an employee.
     * Saves the employee to the database and redirects to the employee list.
     *
     * @param employee The employee object submitted from the form.
     * @return A redirect to the employee list.
     */
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeRepository.save(employee);
        // use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    /**
     * Handles GET requests to delete an employee.
     * Deletes the employee by ID and redirects to the employee list.
     *
     * @param id The ID of the employee to delete.
     * @return A redirect to the employee list.
     */
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id)
    {
        employeeRepository.deleteById(id);
        return "redirect:/employees/list";
    }
}
