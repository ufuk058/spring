package com.thymeleaf.controller;

import com.thymeleaf.bootstrap.DataGenerator;
import com.thymeleaf.model.Student;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register")
    public String register(Model model){

       List<Student> studentList= DataGenerator.createStudentList(10);
       model.addAttribute("studentList",studentList);
        return "student/register";
    }

    @RequestMapping("welcome")
    public String welcomePage(@RequestParam(required = false) String name){


        return "student/welcome";
    }

    @RequestMapping("/drop")
    public String drop(){

        return "student/drop";
    }


}
