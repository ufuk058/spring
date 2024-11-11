package com.dbCon.entity;

import com.dbCon.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name= "Employees")
public class Employee  extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;
    private Gender gender;
    private Double salary;

}
