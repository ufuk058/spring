package com.dbCon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee1 {

    @Id      //this annotation refers the field is primary key
    private Long id;
    private String name;


}
