package com.query.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@Table(name="regions")
@ToString
public class Region extends BaseEntity{

    private String region;
    private String country;

}
