package com.query;

import com.query.repository.DepartmentRepository;
import com.query.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
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

        System.out.println("departmentRepository.findByDepartment(\"Furniture\") = " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("\n\n");
        System.out.println("departmentRepository.findByDivision(\"Health\") = " + departmentRepository.findByDivision("Health"));
        System.out.println("\n\n");
        System.out.println("departmentRepository.findFirst2DivisionOrderByDesc(\"Entertainment\") = " + departmentRepository.findFirst7ByDivisionOrderByDepartmentDesc("Entertainment"));
        System.out.println("\n\n");
        System.out.println("Divisions name ends with 'ics' "+ departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("\n\n");
        System.out.println("Top 2 Divisions, name contains 'Hea' and not duplicate"+departmentRepository.findDistinctTop2ByDivisionContains("Hea"));
        System.out.println("\n\n");


        System.out.println("\n\n\n\n");
    }
}
