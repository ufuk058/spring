package com.thymeleaf.controller;

import com.thymeleaf.bootstrap.DataGenerator;
import com.thymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentListController {

    @RequestMapping("/student-list")
    public String studentList(Model model){
        List<Student> students= DataGenerator.createStudentList(10);
        model.addAttribute("students",students);
        return "student/student-list";
    }
}
