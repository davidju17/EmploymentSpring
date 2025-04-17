package com.davcode.springboot.employment.service;

import com.davcode.springboot.employment.dao.EmployeeDAO;
import com.davcode.springboot.employment.entity.Employee;
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

    @Override
    public void save(Employee employee)
    {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(int id)
    {
        return employeeDAO.findById(id);
    }

    @Override
    public void deleteById(int id)
    {
        employeeDAO.deleteById(id);
    }
}
