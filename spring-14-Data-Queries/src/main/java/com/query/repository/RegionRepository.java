package com.query.repository;

import com.query.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer > {

    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);
}
