/**
 * Classe que gerencia as requisições feitas para o endpoint /login
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.LoggedUser;
import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.enums.UserType;
import com.gabrielpeixoto.eFarm.exceptions.IncorrectPasswordException;
import com.gabrielpeixoto.eFarm.exceptions.UserNotFoundException;
import com.gabrielpeixoto.eFarm.repository.LoggedUserRepository;
import com.gabrielpeixoto.eFarm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    /**
     * Injeção da dependência userService, para acesso a métodos de manipulação de dados no banco de dados
     */
    private UserService userService;

    /**
     * Injeção da dependência loggedUserRepository, para acesso a métodos de manipulação de dados no banco de dados
     */
    private LoggedUserRepository loggedUserRepository;

    /**
     * Obtém acesso à página de login
     * @return o nome do template da página de login
     */
    @GetMapping
    public String goToLogin(Model model)
    {
        User user = new User();
        List<User> users = new ArrayList<>();
        model.addAttribute("userList", users);
        model.addAttribute("loginInfo", user);
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
        List<User> users = new ArrayList<>();
        model.addAttribute("userList", users);
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
        return "redirect:/login";
    }

    /**
     * Processa as informações de login do usuário
     * @param user os dados do usuário
     * @return uma string para redirecionamento de página
     * @throws UserNotFoundException se o usuário não existe
     * @throws IncorrectPasswordException se a senha for incorreta
     */
    @PostMapping("/processaLogin")
    public String login(@ModelAttribute("loginInfo") @Valid User user)
    {
//        System.out.println(userService.getUserByEmail(user.getEmail()).getPassword());
//        System.out.println(user.getPassword());
        //Usuário não encontrado
        if(userService.getUserByEmail(user.getEmail()) == null)
            throw new UserNotFoundException();
        else if(!userService.getUserByEmail(user.getEmail()).getPassword().equals(user.getPassword()))   //Senha incorreta
            throw new IncorrectPasswordException();
        else
        {
            //Salva no banco de dados de usuário logado
            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setLoggedUserEmail(user.getEmail());
            loggedUserRepository.save(loggedUser);
            return "redirect:/legalperson";
        }
    }
}
