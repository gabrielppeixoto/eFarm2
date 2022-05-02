package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    private UserService userService;
    @GetMapping
    public String goToCadastro(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "cadastro";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user)
    {
        userService.saveUser(user);
        return "redirect:/";
    }
}
