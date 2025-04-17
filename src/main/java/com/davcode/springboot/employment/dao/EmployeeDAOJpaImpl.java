package com.davcode.springboot.employment.dao;

import com.davcode.springboot.employment.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    // Define the fields for EntityManager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("from Employee", Employee.class);

        return employeeQuery.getResultList();
    }

    @Override
    public Employee save(Employee employee)
    {
        return entityManager.merge(employee);
    }

    @Override
    public Employee findById(int id)
    {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteById(int id)
    {
        //Find the employee by id first
        Employee employee = entityManager.find(Employee.class, id);

        if (employee != null)
        {
            entityManager.remove(employee);
        }
    }
}
