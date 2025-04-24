package com.davcode.springboot.employment.controller;

import com.davcode.springboot.employment.dao.EmployeeRepository;
import com.davcode.springboot.employment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/list")
    public String listEmployees(Model model)
    {
        List<Employee> employees = employeeRepository.findAll();

        // Add the list of employees to the model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
