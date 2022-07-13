/**
 * Classe que gerencia as requisições feitas para o endpoint /login
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.enums.UserType;
import com.gabrielpeixoto.eFarm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    /**
     * Injeção da dependência userService, para acesso a métodos de manipulação de dados no banco de dados
     */
    private UserService userService;

    /**
     * Obtém acesso à página de login
     * @return o nome do template da página de login
     */
    @GetMapping
    public String goToLogin()
    {
        return "login";
    }

    /**
     * Obtém acesso à página de cadastro de usuário, e cria um novo objeto
     * para conter os dados digitados
     * @param model
     * @return o nome do template da página de cadastro
     */
    @GetMapping("/cadastro")
    public String createSignUpForm(Model model)
    {
        //Create object to hold user data
        User user = new User();
        model.addAttribute("user", user);
        return "cadastro";
    }

    /**
     * Salva os dados do novo usuário, e volta para a tela de login
     * @param user os dados a serem salvos
     * @return redirecionamento para a tela de login
     */
    @PostMapping("/cadastro/new")
    public String saveUser(@ModelAttribute("user") @Valid User user)
    {
        userService.saveUser(user);
        //Vai para a página adequada de acordo com o tipo do usuário
        if(user.getUserType() == UserType.PESSOA_FISICA)
            return "redirect:/physicalperson";
        else if(user.getUserType() == UserType.PESSOA_JURIDICA)
            return "redirect:/legalperson";
        return "redirect:/login";
    }
}
