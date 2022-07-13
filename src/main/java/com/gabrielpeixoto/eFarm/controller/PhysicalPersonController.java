/**
 * Classe que gerencia as requisiçõs para a página de usuários Pessoa Física
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/physicalperson")
public class PhysicalPersonController {
    /**
     * Obtém acesso à página de login
     * @return o nome do template da página de login
     */
    @GetMapping
    public String goToPage()
    {
        return "physical_person_dashboard";
    }
}
