package ioc.bean_annotation.config;

import ioc.bean_annotation.carFactory.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {

    @Primary
    @Bean
    public Car myCar1(){
        Car c= new Car();
        c.setMake("Honda");
        return c;
    }

    @Bean
    public Car myCar2(){
        Car c= new Car();
        c.setMake("Nissan");
        return c;
    }

    @Bean
    public Car myCar3(){
        Car c= new Car();
        c.setMake("Toyota");
        return c;
    }



}
