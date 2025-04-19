package com.davcode.springboot.employment.service;

import com.davcode.springboot.employment.dao.EmployeeDAO;
import com.davcode.springboot.employment.entity.Employee;
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
    private EmployeeDAO employeeDAO;

    /**
     * Constructor for EmployeeServiceImpl.
     *
     * @param employeeDAO the DAO used to manage employee data.
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }


    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public Employee save(Employee employee)
    {
        return employeeDAO.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findById(int id)
    {
        return employeeDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void deleteById(int id)
    {
        employeeDAO.deleteById(id);
    }
}
