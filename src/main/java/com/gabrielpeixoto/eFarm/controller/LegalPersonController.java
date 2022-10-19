/**
 * Classe que gerencia as requisiçõs para a página de usuários Pessoa Jurídica
 * @author Gabriel Porto Santos Peixoto
 */
package com.gabrielpeixoto.eFarm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielpeixoto.eFarm.entity.AvailableDrugs;
import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.Product;
import com.gabrielpeixoto.eFarm.repository.AvailableDrugsRepository;
import com.gabrielpeixoto.eFarm.repository.DrugstoreRepository;
import com.gabrielpeixoto.eFarm.repository.LoggedUserRepository;
import com.gabrielpeixoto.eFarm.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
    private AvailableDrugsRepository availableDrugsRepository;

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

    //TODO disponibilizar, no banco de dados, farmácias já existentes

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
        return "updateDrugstore";
    }

    @PostMapping("/editDrugstore/change")
    public String saveUpdateChanges(@ModelAttribute("drugstore") Drugstore drugstore)
    {
        drugstoreRepository.save(drugstore);
        return "redirect:/legalperson";
    }

    @GetMapping("/update")
    public String goToUpdatePage(Model model)
    {
        Drugstore drugstore = new Drugstore();
        List<AvailableDrugs> availableDrugs = availableDrugsRepository.findAll();
        model.addAttribute("drugstore", drugstore);
        model.addAttribute("available_drugs", availableDrugs);
        return "addProduct";
    }

    /**
     * Funções reservadas para consulta a medicamentos via API externa
     */

    @GetMapping("/search")
    public String goToDrugSearchPage(Model model)
    {
        List<Product> result = new ArrayList<>();
        model.addAttribute("result", result);
        return "drugRegisterForm";
    }

    @GetMapping(value = {"/search/{dName}", "/search"})
    public String searchDrugs(@PathVariable("dName") Optional<String> drugName, Model model) throws JsonProcessingException {
        List<String> results = new ArrayList<>();
        if(drugName.isPresent())
        {
            String url = "https://bula.vercel.app/pesquisar?nome=" + drugName;
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> entity = template.getForEntity(url, String.class);
            // Trata o JSON da resposta
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(entity.getBody());
            JsonNode content = root.path("content");
            //Como a resposta deve ser uma array de objetos, utiliza um iterador para percorrê-los
            Iterator<JsonNode> nodeIterator = content.elements();
            //Adiciona cada nome de medicamento na lista de resultados
            nodeIterator.forEachRemaining(node -> results.add(node.path("nomeProduto").asText()));
        }
        model.addAttribute("result", results);
        return "drugRegisterForm";
    }
}
