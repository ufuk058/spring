package com.modelMVC.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FakerConfig {

    @Bean
    public Faker fakerBean(){
        return new Faker();
    }
}
