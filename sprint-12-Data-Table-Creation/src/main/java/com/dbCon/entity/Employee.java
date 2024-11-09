package com.dbCon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Employee {

    @Id      //this annotation refers the field is primary key
    private Long id;
    private String name;


}
