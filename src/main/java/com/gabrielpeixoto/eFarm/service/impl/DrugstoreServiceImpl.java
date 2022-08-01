/**
 * Classe que implementa os métodos definidos na interface DrugstoreService
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.service.impl;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.repository.DrugstoreRepository;
import com.gabrielpeixoto.eFarm.service.DrugstoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DrugstoreServiceImpl implements DrugstoreService {

    /**
     * Injeção da dependência, para poder realizar as consultas
     */
    private DrugstoreRepository drugstoreRepository;

    @Override
    public List<Drugstore> getAllDrugstores() {
        return drugstoreRepository.findAll();
    }

    @Override
    public Drugstore saveDrugstore(Drugstore drugstore) {
        return drugstoreRepository.save(drugstore);
    }

    @Override
    public List<Drugstore> getDrugstoreByOwner(User user) {
        return null;
    }

    @Override
    public void deleteDrugstore(Long id) {
        drugstoreRepository.deleteById(id);
    }
}
