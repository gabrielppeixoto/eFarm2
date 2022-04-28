package com.gabrielpeixoto.eFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    @GetMapping
    public String goToCadastro()
    {
        return "cadastro";
    }
}
