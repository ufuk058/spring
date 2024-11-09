package com.dbCon.entity;

import com.dbCon.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="Students") //This annotation is for renaming the table instead class name (Student)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is for generating the primary key id automatically
    private Long id;

    @Column(name="studentFirstName") //renaming the column, will be : student_first_name
    private String firstName;

    @Column(name="studentLastName") // renaming the column name will be : student_last_name
    private String lastName;

    private String email;


    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column(columnDefinition = "DATE")
    private LocalTime birthTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDatTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient //This annotation ignores the field so not create a column in database
    private String city;


}
