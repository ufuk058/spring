package com.dbCon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="Departments")
@AllArgsConstructor
public class Department  extends BaseEntity {

    private String department;
    private String division;


}
