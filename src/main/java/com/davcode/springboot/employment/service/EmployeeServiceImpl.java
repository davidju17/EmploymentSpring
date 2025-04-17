package com.davcode.springboot.employment.service;

import com.davcode.springboot.employment.dao.EmployeeDAO;
import com.davcode.springboot.employment.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee)
    {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(int id)
    {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(int id)
    {
        employeeDAO.deleteById(id);
    }
}
