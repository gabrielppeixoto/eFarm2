/**
 * Classe que gerencia as requisições feitas para o endpoint "/"
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    /**
     * Obtém acesso à página inicial
     * @return o nome do template da página inicial
     */
    @GetMapping
    public String homePage(Model model)
    {
        model.addAttribute("index");
        return "index";
    }
}
