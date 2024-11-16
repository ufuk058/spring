package com.query.repository;

import com.query.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display employees that first name contains Jack
    List<Employee> findByFirstNameContains(String name);

    //Display all employees with email address;
    List<Employee> findByEmail(String email);

    //Display all employees with firstName and LastName
    List<Employee> findByFirstNameAndLastName(String firstName, String LastName);

    //Display all employees with firstName or LastName
    List<Employee> findByFirstNameOrLastName(String firstName, String LastName);

    //Display all employees where first name is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where lastName starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salary higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salary less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display count of Employees with salary more than ""
    Integer countBySalaryGreaterThan(Integer Salary);

    //Display  all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order Salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top3 unique employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    //Display count of Employees with email is null
    Integer countByEmailIsNull();

    //--------------- Joins -----------------------

    //Display all employees who are working in Division "Health"
    List<Employee> findByDepartmentDivision(String division);  //Department is the object name in the Employee Table

    //Display all Employees who are working in Country Canada
    List<Employee> findByRegionCountry(String country);  //Region is the object name that created in the Employee Table

    // Display All Employees where the region is "Northeast"
    List<Employee> findByRegionRegion(String regionName); //First Region is Object Second Region is Field in the object

    //Display count of Employees Working from Canada
    Integer countByRegionCountry(String country);




}
