package com.davcode.springboot.employment.entity;

import jakarta.persistence.*;

/**
 * Represents the Employee entity mapped to the "employee" table in the database.
 */
@Entity
@Table(name="employee")
public class Employee
{
    /**
     * Unique identifier for the employee. Automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * First name of the employee.
     */
    @Column(name="first_name")
    private String firstName;

    /**
     * Last name of the employee.
     */
    @Column(name="last_name")
    private String lastName;

    /**
     * Email address of the employee.
     */
    @Column(name="email")
    private String email;

    /**
     * Default constructor required by JPA.
     */
    public Employee()
    {
    }

    /**
     * Constructor to initialize an employee with first name, last name, and email.
     *
     * @param firstName First name of the employee.
     * @param lastName Last name of the employee.
     * @param email Email address of the employee.
     */
    public Employee(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the unique identifier of the employee.
     *
     * @return Employee ID.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id Employee ID.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Gets the first name of the employee.
     *
     * @return First name of the employee.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName First name of the employee.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return Last name of the employee.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName Last name of the employee.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the employee.
     *
     * @return Email address of the employee.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email Email address of the employee.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Returns a string representation of the Employee object.
     *
     * @return String representation of the employee.
     */
    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
