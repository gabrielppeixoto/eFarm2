/**
 * Interface que define alguns tipos de consultas para farmácias
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.service;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DrugstoreService {
   /**
    * Obtem todas as farmácias
    * @return uma lista com as farmácias
    */
   List<Drugstore> getAllDrugstores();

   /**
    * Salva uma farmácia no banco de dados
    * @param drugstore a farmácia a ser salva
    * @return os dados da farmácia salva
    */
   Drugstore saveDrugstore(Drugstore drugstore);

   /**
    * Obtém a farmáci via seu proprietário
    * @param user o proprietário a ser pesquisado
    * @return a lista de farmácias das quais ele é dono
    */
   List<Drugstore> getDrugstoreByOwner(User user);

   /**
    * Elimina uma farmácia do banco de dados
    * @param id o ID da farmácia a ser eliminada
    */
   void deleteDrugstore(Long id);
}
