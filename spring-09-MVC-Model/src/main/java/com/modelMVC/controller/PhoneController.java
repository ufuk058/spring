package com.modelMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhoneController {

    @RequestMapping("/phone")
    public String phoneDisplay(@RequestParam(value="phone") String phoneBrand, @RequestParam(value="model") String phoneModel, Model model){
        model.addAttribute("phone",phoneBrand);
        model.addAttribute("model",phoneModel);
        return "phone/phone-spec";
    }
}
