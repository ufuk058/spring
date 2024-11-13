package com.dbCon.repository;

import com.dbCon.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
@Repository annotation is a child annotation of @Component for the dependency injection
But in this case We don't need to add it, because JpaRepository interface that already injected.
We can put it in Repository classes to mark them as Repository
*/
public interface CarRepository extends JpaRepository<Car, Long> {
}
