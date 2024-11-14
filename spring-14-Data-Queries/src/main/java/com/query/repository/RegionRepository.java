package com.query.repository;

import com.query.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer > {

    //Display all Regions by country name
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContains(String country);

    //Display all regions with country name includes 'United' in order (ASC)
    List<Region> findByCountryContainsOrderByRegion(String country);

    //Display top 2 regions in United States
    List<Region> findTop2ByCountry(String country );
    List<Region> findTopByCountry(String country );
    List<Region> findFirst2ByCountry(String country);

    List<Region> findTop2ByCountryContainsOrderByRegionDesc(String country);

}
