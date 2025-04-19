package com.davcode.springboot.employment.dao;

import com.davcode.springboot.employment.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the EmployeeDAO interface that uses JPA for data access.
 * This class is responsible for performing CRUD operations on Employee entities.
 */
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    private EntityManager entityManager;

    /**
     * Constructor for EmployeeDAOJpaImpl.
     *
     * @param entityManager The EntityManager used for database operations.
     */
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> findAll()
    {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("from Employee", Employee.class);
        return employeeQuery.getResultList();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Employee save(Employee employee)
    {
        return entityManager.merge(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findById(int id)
    {
        return entityManager.find(Employee.class, id);
    }

    /**
     * {@inheritDoc}
     */
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
