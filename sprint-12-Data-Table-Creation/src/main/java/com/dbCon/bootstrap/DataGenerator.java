package com.dbCon.bootstrap;

import com.dbCon.entity.Car;
import com.dbCon.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // this annotation is for injection (connect the java class to the spring framework)
public class DataGenerator implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //creating some car objects
        Car car1 = new Car("BMW","M3");
        Car car2 = new Car("Audi","RS6");
        Car car3 = new Car("Lexus","CT200h");
        Car car4 = new Car("Honda","Jazz");

        //We need to save these objects to database
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
    }



}
