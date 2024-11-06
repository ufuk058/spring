package com.modelMVC.controller;

import com.modelMVC.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String welcomePage(Model model){

     model.addAttribute("name","Hello Ufuk" );
     model.addAttribute("course","MVC");
     String studentName="Esra";
     model.addAttribute("studentName",studentName);

     int studentId= new Random().nextInt(1000);
     model.addAttribute("studentId",studentId);

        List<Integer> numbers= new ArrayList<>(Arrays.asList(1,2,3,4,5));
        model.addAttribute("numbers",numbers);

        List<String> classmates=new ArrayList<>(Arrays.asList("Ahmet","Neslihan","Ayse","Meryem"));
        model.addAttribute("classmates",classmates);

        Student student= new Student(1,"John","Smith");
        model.addAttribute("student",student);

     return "student/welcome";
    }
}
