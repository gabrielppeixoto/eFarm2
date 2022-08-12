/**
 * Classe que gerencia as requisiçõs para a página de usuários Pessoa Física
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.controller;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.repository.DrugstoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/physicalperson")
@AllArgsConstructor
public class PhysicalPersonController {

    /**
     * Injeção das dependências
     */
    private DrugstoreRepository drugstoreRepository;
    /**
     * Obtém acesso à página de login
     * @return o nome do template da página de login
     */
    @GetMapping
    public String goToPage(Model model)
    {
        Drugstore d = new Drugstore();
        model.addAttribute("drugName", d);
        return "physical_person_dashboard";
    }

    @PostMapping("/search")
    public String searchDrugs(@ModelAttribute("drugName") String name, Model model)
    {
        List<Drugstore> drugstoreList = drugstoreRepository.findDrugstoresByStoreContainingDrug(name);
        Integer drugstoreNumber = drugstoreRepository.countDrugstoresByDrug(name);
        model.addAttribute("drugstoreList", drugstoreList);
        model.addAttribute("dsCount", drugstoreNumber);
        return "showDrugstores";
    }
}
