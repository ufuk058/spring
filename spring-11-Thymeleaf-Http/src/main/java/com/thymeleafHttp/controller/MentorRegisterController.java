package com.thymeleafHttp.controller;

import com.thymeleafHttp.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller

@RequestMapping("/mentor")
public class MentorRegisterController {

    @GetMapping("/register")
    public String postMethod(Model model){
        //provide empty Mentor object that you want user to fill
        model.addAttribute("mentor",new Mentor());

        //provide needed information for the dropdown options
        List<String> batch= Arrays.asList("JD1","JD2","JD3","JD4","JD5","JD6","Ahmet","Mehmet");
        model.addAttribute("batch",batch);

        //create connection between html form and empty object
        //get the filled object to our application

        return "mentor/register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){ //this is fo assigning filled info to mentor Object

        System.out.println(mentor);

        return "redirect:/mentor/register";
    }
}
