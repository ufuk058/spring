package com.query;

import com.query.repository.DepartmentRepository;
import com.query.repository.EmployeeRepository;
import com.query.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n\n\n");
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

        System.out.println("######## EMPLOYEE ########");
        System.out.println(" Jack Names : "+employeeRepository.findByFirstNameContains("Jack"));
        System.out.println("FirstAndLastName: "+employeeRepository.findByFirstNameAndLastName("Jania", "Gresly"));
        System.out.println("\n\n");
        System.out.println("FirstAndLastName: "+employeeRepository.findByFirstNameOrLastName("Jania", "Gresly"));
        System.out.println("\n\n");
        System.out.println("Salary More than 166700 " + employeeRepository.findBySalaryGreaterThan(166700));
        System.out.println("\n\n");
        System.out.println("How many people makes salary more than 150000: "+ employeeRepository.countBySalaryGreaterThan(150000));
        System.out.println("\n\n");
        System.out.println("Employees with salary equals and Greater Than 50000: " + employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(50000));
        System.out.println("\n\n");
        System.out.println("Top3 makes less than 100000 " + employeeRepository.findDistinctTop3BySalaryLessThan(100000));
        System.out.println("\n\n");
        System.out.println("Employees email is null: " + employeeRepository.findByEmailIsNull());
        System.out.println("\n\n");
        System.out.println("Employee Count of null email: "+ employeeRepository.countByEmailIsNull());


        System.out.println("#### JOINS ######");

        System.out.println("\n\n\n\n");
    }
}
