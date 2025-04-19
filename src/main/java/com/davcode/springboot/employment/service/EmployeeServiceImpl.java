package com.davcode.springboot.employment.service;

import com.davcode.springboot.employment.entity.Employee;
import com.davcode.springboot.employment.dao.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the EmployeeService interface that provides
 * methods to perform CRUD operations on Employee entities.
 * This service acts as an intermediary layer between the REST controllers
 * and the data access objects.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    /**
     * Constructor for EmployeeServiceImpl.
     *
     * @param employeeRepository The repository used to manage employee data.
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findById(int id)
    {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int id)
    {
        employeeRepository.deleteById(id);
    }
}
