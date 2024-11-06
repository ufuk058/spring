package com.thymeleaf.bootstrap;

import com.github.javafaker.Faker;
import com.thymeleaf.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    public static List<Student> createStudentList(int studentCount){
        Faker faker= new Faker();
        List<Student> list= new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            UUID id= UUID.randomUUID();
            String firstName=faker.name().firstName();
            String lastName= faker.name().lastName();
            int age= faker.number().numberBetween(15,60);
            String state= faker.address().state();
            Student student= new Student(id,firstName,lastName,age,state);

            list.add(student);
        }
        return list;
    }
}
