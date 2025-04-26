package com.davcode.springboot.employment.controller;

import com.davcode.springboot.employment.dao.EmployeeRepository;
import com.davcode.springboot.employment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();

        // Add the list of employees to the model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Employee theEmployee, Model model)
    {
        Optional<Employee> optionalEmployeebyId = employeeRepository.findById(id);

        Employee employee = optionalEmployeebyId.orElseThrow(() -> new RuntimeException("Employee not found"));

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeRepository.save(employee);
        // use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id)
    {
        employeeRepository.deleteById(id);
        return "redirect:/employees/list";
    }
}
