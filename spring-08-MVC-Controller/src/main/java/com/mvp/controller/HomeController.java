package com.mvp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String methodHome(){

        return "home.html";
    }

    @RequestMapping
    public String defaultPage(){
        return "home.html";
    }

    @RequestMapping("/myPage")
    public String myPage(){
        return "myPage.html";
    }

    @RequestMapping({"/index","/login"})
    public String indexAndHome(){
        return "home.html";
    }
}
