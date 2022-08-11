/**
 * Classe que gerencia as requisiçõs para a página de usuários Pessoa Jurídica
 * @author Gabriel Porto Santos Peixoto
 */
package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.repository.DrugstoreRepository;
import com.gabrielpeixoto.eFarm.repository.LoggedUserRepository;
import com.gabrielpeixoto.eFarm.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/legalperson")
@AllArgsConstructor
public class LegalPersonController {
    /**
     * Injeção das dependências
     */
    private UserRepository userRepository;
    private DrugstoreRepository drugstoreRepository;
    private LoggedUserRepository loggedUserRepository;
    /**
     * Obtém acesso à página de login
     * @return o nome do template da página de login
     */
    @GetMapping
    public String goToPage()
    {
        return "legal_person_dashboard";
    }

    /**
     * OBtém acesso ao formulário de cadastro de farmácio
     * @param model atributo que contém os campos do modelo, que serão vinculados aos campos do formulário
     * @return uma string de redirecionamento para a página do formulário
     */
    @GetMapping("/register")
    public String goToDrugstorePage(Model model)
    {
        Drugstore drugstore = new Drugstore();
        model.addAttribute("drugstore", drugstore);
        return "registerDrugstore";
    }

    /**
     * Configura o atributo CNPJ e cadastra a farmácia no banco de dados
     * @param drugstore a farmácia a ser cadastrada
     * @return uma string de redirecionamento para a página de dashboard
     */
    @PostMapping("/register/new")
    public String saveDrugstore(@ModelAttribute("drugstore") @Valid Drugstore drugstore)
    {
        drugstore.setUser(userRepository.findByEmail(loggedUserRepository.getLastLoggedUser()));
        drugstoreRepository.save(drugstore);
        return "redirect:/legalperson";
    }

    /**
     * Realiza o logout da aplicação e retorna à página principal
     * @return string de redirecionamento para a página principal
     */
    @PostMapping("/exit")
    public String logOut()
    {
        loggedUserRepository.deleteAll();
        return "redirect:/";
    }

    /**
     * Acessa a página de gerenciamento das farmácias do usuário
     * @param model atributo que conterá todos os objetos 'Drugstore' relacionados ao usuário
     * @return uma string com o nome do template
     */
    @GetMapping("/manageDrugstore")
    public String goToManagementPage(Model model)
    {
        List<Drugstore> drugstores = drugstoreRepository.findDrugstoresByUser(userRepository.findByEmail(loggedUserRepository.getLastLoggedUser()));
        model.addAttribute("drugstores", drugstores);
        return "manageDrugstore";
    }

    /**
     * Acessa a página de atualização de informações da farmácia
     * @param model atributo que conterá todos os objetos 'Drugstore' relacionados ao usuário
     * @return uma string com o nome do template
     */
    @GetMapping("/editDrugstore")
    public String goToEditDrugstorePage(Model model)
    {
        Drugstore drugstore = new Drugstore();
        model.addAttribute("drugstore", drugstore);
        return "paginaAtualizacao";
    }

    @GetMapping("/update")
    public String goToUpdatePage(Model model)
    {
        Drugstore drugstore = new Drugstore();
        model.addAttribute("drugstore", drugstore);
        return "pagina";
    }
}
