package com.query;

import com.query.repository.CourseRepository;
import com.query.repository.DepartmentRepository;
import com.query.repository.EmployeeRepository;
import com.query.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("\n\n\n\n\n");
        /*System.out.println("regionRepository.findByCountry(\"Canada\") = " + regionRepository.findByCountry("Canada"));
        System.out.println("\n\n");
        System.out.println("regionRepository.getByCountry(\"Asia\") = " + regionRepository.getByCountry("Asia"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findByCountryContains(\"United\") = " + regionRepository.findByCountryContains("United"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findByCountryOrderByRegion(\"United\") = " + regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findTopByCountry(\"United States\") = " + regionRepository.findTopByCountry("United States"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findTop2ByCountry(\"Canada\") = " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findFirst2ByCountry(\"United States\") = " + regionRepository.findFirst2ByCountry("United States"));
        System.out.println("\n\n");
        System.out.println("regionRepository.findTopByCountryContainsOrderByRegion(\"United\") = " + regionRepository.findTop2ByCountryContainsOrderByRegionDesc("United"));
        System.out.println("\n\n");

         */

//        System.out.println("######  DEPARTMENT ######");
//        System.out.println("departmentRepository.findByDepartment(\"Furniture\") = " + departmentRepository.findByDepartment("Furniture"));
//        System.out.println("\n\n");
//        System.out.println("departmentRepository.findByDivision(\"Health\") = " + departmentRepository.findByDivision("Health"));
//        System.out.println("\n\n");
//        System.out.println("departmentRepository.findFirst2DivisionOrderByDesc(\"Entertainment\") = " + departmentRepository.findFirst7ByDivisionOrderByDepartmentDesc("Entertainment"));
//        System.out.println("\n\n");
//        System.out.println("Divisions name ends with 'ics' "+ departmentRepository.findByDivisionEndsWith("ics"));
//        System.out.println("\n\n");
//        System.out.println("Top 2 Divisions, name contains 'Hea' and not duplicate"+departmentRepository.findDistinctTop2ByDivisionContains("Hea"));
//        System.out.println("\n\n");

//        System.out.println("######## EMPLOYEE ########");
//        System.out.println(" Jack Names : "+employeeRepository.findByFirstNameContains("Jack"));
//        System.out.println("FirstAndLastName: "+employeeRepository.findByFirstNameAndLastName("Jania", "Gresly"));
//        System.out.println("\n\n");
//        System.out.println("FirstAndLastName: "+employeeRepository.findByFirstNameOrLastName("Jania", "Gresly"));
//        System.out.println("\n\n");
//        System.out.println("Salary More than 166700 " + employeeRepository.findBySalaryGreaterThan(166700));
//        System.out.println("\n\n");
//        System.out.println("How many people makes salary more than 150000: "+ employeeRepository.countBySalaryGreaterThan(150000));
//        System.out.println("\n\n");
//        System.out.println("Employees with salary equals and Greater Than 50000: " + employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(50000));
//        System.out.println("\n\n");
//        System.out.println("Top3 makes less than 100000 " + employeeRepository.findDistinctTop3BySalaryLessThan(100000));
//        System.out.println("\n\n");
//        System.out.println("Employees email is null: " + employeeRepository.findByEmailIsNull());
//        System.out.println("\n\n");
//        System.out.println("Employee Count of null email: "+ employeeRepository.countByEmailIsNull());


//        System.out.println("#### JOINS ######");

//        System.out.println("All Employees working in Health division: "+ employeeRepository.findByDepartmentDivision("Health"));
//        System.out.println("\n\n");
//        System.out.println("Employees from Canada: "+ employeeRepository.findByRegionCountry("Canada"));
//        System.out.println("Based on Region Name 'Northeast': "+ employeeRepository.findByRegionRegion("Northeast"));
//        System.out.println("Number of Employee working from Canada: "+ employeeRepository.countByRegionCountry("United States"));
//
//        System.out.println("\n\n\n\n");


//        System.out.println("#####  Courses  ####");
//       // System.out.println("All Courses with Spring Category: "+ courseRepository.findByCategory("Spring"));
//        System.out.println("\n\n\n");
//        System.out.println("All Courses with Spring Category Asc Order"+ courseRepository.findByCategoryOrderByName("Spring"));
//        System.out.println("\n\n\n");
//        System.out.println("All category Count: "+courseRepository.countByIdIsNotNull());
//        System.out.println("If the course exist with name :"+courseRepository.existsByName("Spring Boot Application Development"));
//        System.out.println("Count courses by given name :"+courseRepository.countByCategory("Rapid Spring Boot Application Development"));
//        System.out.println("\n\n\n");
//        System.out.println("Find Courses name starts with given string: "+courseRepository.findByNameStartsWith("Rapid"));
//        System.out.println("\n\n\n");

        ///##### JPQL Queries #########
//        System.out.println("Employee Salary ByJPQL: "+employeeRepository.getEmployeeSalary());
//        //System.out.println("Retrieve all employees: \n\n"+employeeRepository.retrieveAllEmployees());
//        System.out.println("amcnee1@google.es Employee Detail: "+ employeeRepository.retrieveEmployeeDetail());
//        System.out.println("Find the employee with salary is Equal 86895 :"+ employeeRepository.retrieveEmployeeSalaryEqual(86895));
//        System.out.println("FirstName Like given firstName: "+ employeeRepository.retrieveEmployeeFirstNameLike("James"));
//        System.out.println("Salary Less Than: "+employeeRepository.retrieveEmployeeSalaryLessThan(30000));
//        System.out.println("First names with salary greater than 160000: "+ employeeRepository.retrieveEmployeeFirstNamesGreaterThanSalary(160000));
//        System.out.println("Salaries Between: "+ employeeRepository.retrieveEmployeeSalaryBetween(100000, 105000));
//        System.out.println("Employees hired after certain date: "+
//                employeeRepository.retrieveEmployeesHireDateGreaterThan(LocalDate.of(2005,01,01)));
//        System.out.println("Employees with null email: "+ employeeRepository.retrieveEmployeesEmailIsNull());
//        System.out.println("Not null email Employee Count: "+ employeeRepository.getNotNullEmailEmployeeCount());
//        System.out.println("Salary DEsc Order: "+ employeeRepository.retrieveEmployeesDescOrderBySalary());

        /// Queries With the named parameters
//        System.out.println("Employee salary : "+employeeRepository.retrieveEmployeeSalary(112796));
//        System.out.println("Name or Salary: "+ employeeRepository.retrieveFirstNameOrSalary(112796,"Thorvald"));
        /// Join Queries
       // System.out.println("Employees by specific division: "+ employeeRepository.retrieveEmployeeByDivision("Health"));
//        System.out.println("Employee by Country: "+employeeRepository.retrieveEmployeeByCountry("Canada"));

        /// ### for Multiple Inputs ####

//        System.out.println("Departments with multiple divisions: "+
//                departmentRepository.retrieveDepartmentByDivision("Fashion","Health","Entertainment"));

        System.out.println("Multiple divisions: "+
                departmentRepository.retrieveDepartmentByMultipleDivisions(new ArrayList<>(Arrays.asList("Fashion","Health","Electronics","Entertainment"))));



    }
}
