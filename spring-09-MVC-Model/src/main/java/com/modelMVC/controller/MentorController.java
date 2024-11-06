package com.modelMVC.controller;

import com.github.javafaker.Faker;
import com.modelMVC.enums.Gender;
import com.modelMVC.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String mentorController(Model model){

        List<Mentor> mentors= mentorList(4);
        model.addAttribute("mentors",mentors);
        return "mentor/mentor-list";
    }

    private List<Mentor> mentorList(int mentorCount){

        List<Mentor> mentorList= new ArrayList<>();

        Faker faker= new Faker();
        for (int i = 0; i < mentorCount; i++) {
            String firstName=faker.name().firstName();

            String lastName=faker.name().lastName();
            int age= faker.number().numberBetween(10,45);
            Mentor mentor= new Mentor(firstName,lastName,age,randomGender());
            mentorList.add(mentor);
        }
        return mentorList;
    }

    private Gender randomGender(){

        List<Gender> genders= new ArrayList(Arrays.asList(Gender.values()));
        return genders.get(new Random().nextInt(Gender.values().length));
    }


}
