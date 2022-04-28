package com.gabrielpeixoto.eFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String homePage(Model model)
    {
        model.addAttribute("index");
        return "index";
    }
}
