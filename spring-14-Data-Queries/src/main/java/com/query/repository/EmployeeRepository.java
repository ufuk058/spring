package com.query.repository;

import com.query.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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


    /// ##### JPQL Queries ########
    @Query("SELECT e.salary FROM Employee e Where e.email='amcnee1@google.es'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e")
    List<Employee> retrieveAllEmployees();

    @Query("Select e from Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();


    ///equal

    @Query("Select e from Employee e where e.salary=?1")
    List<Employee> retrieveEmployeeSalaryEqual(int salary);

    @Query("Select e from Employee e where e.salary <>?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    /// Like / Contains / starts-ends with
    @Query("Select e from Employee e where e.firstName LIKE CONCAT('%',?1,'%')")
    List<Employee> retrieveEmployeeFirstNameLike(String firstName);

    ///Less than
    @Query("Select e from Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    ///Greater than salary, but first names
    @Query("Select e.firstName from Employee e where e.salary > ?1")
    List<String> retrieveEmployeeFirstNamesGreaterThanSalary(int salary);

    ///Salary between
    @Query("Select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salaryStart, int salaryEnd);


    /// Employees with specific hire date
    @Query("Select e from Employee e where e.hireDate >?1 ")
    List<Employee> retrieveEmployeesHireDateGreaterThan( LocalDate hireDate);

    //Employees with email is null
    @Query("Select e from Employee e where e.email IS NULL")
    List<Employee> retrieveEmployeesEmailIsNull();

    //Employees with email is not null
    @Query("Select e from Employee e where e.email IS NOT NULL")
    List<Employee> retrieveEmployeesEmailIsNotNull();

    /// Number of Employees with not null email
    @Query("Select Count(e.email) from Employee e where e.email IS NOT NULL")
    Integer getNotNullEmailEmployeeCount();


    ///Sorting Asc
    @Query("Select e from Employee e Order By e.salary DESC")
    List<Employee> retrieveEmployeesDescOrderBySalary();

    /// ########   Queries with Names Parameters ########

    /// Named Parameter
    @Query("Select e from Employee e where e.salary  = :salary ")
    List<Employee> retrieveEmployeeSalary(@Param("salary")int salary);

    @Query("Select e from Employee e where e.firstName=:name OR e.salary=:salary")
    List<Employee> retrieveFirstNameOrSalary(@Param("salary") int salary, @Param("name") String name);

    /// Display all employees who are working in division  "Health"
    // @Query("Select e from Employee e where e.department.division=?1") method parameter only String division
    @Query("Select e from Employee e where e.department.division = :division")
    List<Employee> retrieveEmployeeByDivision(@Param("division") String division);

    /// Display all employees who are working in country "Canada"
    @Query("Select e from Employee e where e.region.country=:country")
    List<Employee> retrieveEmployeeByCountry(@Param("country") String country);


    /// ######   Native Sql Queries ####
    @Query(value = "Select * from Employees where salary=:salary",nativeQuery = true)
    List<Employee> retrieveEmployeeSalaryNative(@Param("salary")int salary);
    ///this query retrieve data from postgres table, not the Java entity.
    /// If the database name changes in the future in any chance native query will not work


}
