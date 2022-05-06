package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private UserService userService;

    @GetMapping
    public String goToLogin()
    {
        return "login";
    }

    @GetMapping("/cadastro")
    public String createSignUpForm(Model model)
    {
        //Create object to hold user data
        User user = new User();
        model.addAttribute("user", user);
        return "cadastro";
    }

    @PostMapping("/cadastro/new")
    public String saveUser(@ModelAttribute("user") User user)
    {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
