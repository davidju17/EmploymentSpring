package com.davcode.springboot.employment.dao;

import com.davcode.springboot.employment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface for Employee entities.
 * Provides CRUD operations and other JPA functionalities for Employee objects.
 * The Integer parameter represents the type of the primary key of the Employee entity.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    // No additional methods are needed as JpaRepository provides basic CRUD operations
    // and other JPA functionalities out of the box.
}
