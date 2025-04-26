package com.davcode.springboot.employment.dao;

import com.davcode.springboot.employment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * Repository interface for Employee entities.
 * Provides CRUD operations and other JPA functionalities for Employee objects.
 * The Integer parameter represents the type of the primary key of the Employee entity.
 */
@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    // No additional methods are needed as JpaRepository provides basic CRUD operations
    // and other JPA functionalities out of the box.

    /**
     * Finds all employees and orders them by last name in ascending order.
     *
     * @return the list of all employees ordered by last name in ascending order.
     */
    List<Employee> findAllByOrderByLastNameAsc();
}
