package com.query.repository;

import com.query.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments in the Furniture Department
    Optional<Department> findByDepartment(String department);
    List<Department>  findByDivision(String division);
    List<Department> findFirst7ByDivisionOrderByDepartmentDesc(String division);

    //Display all departments in the 'any' Department --> all below methods return same result
    //1 - List<Department> findByDivision(String department)
    /* 2 */ List<Department> findByDivisionIs(String division);
    /* 3 */ List<Department> findByDivisionEquals(String division);
    /* 4 */ List<Department> findAllByDivisionEquals(String division);


    //Display all departments with division name start with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);

    //Display top 2 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop2ByDivisionContains(String division);

    ///result with multiple inputs like display all dept belongs the foll divisions "Fashion", "Entertainment"
    @Query("Select d from Department d where d.division =?1 OR d.division=?2 OR d.division=?3")
    List<Department> retrieveDepartmentByDivision(String division1, String division2, String division3);

    ///What if 50 inputs
    @Query("Select d from Department d where d.division IN ?1")
    List<Department> retrieveDepartmentByMultipleDivisions(List<String> divisions);



}
