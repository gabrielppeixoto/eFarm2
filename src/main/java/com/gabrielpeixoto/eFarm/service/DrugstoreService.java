package com.gabrielpeixoto.eFarm.service;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DrugstoreService {
   List<Drugstore> getAllDrugstores();
   Drugstore saveDrugstore(Drugstore drugstore);
   List<Drugstore> getDrugstoreByOwner(User user);
   void deleteDrugstore(Long id);
}
