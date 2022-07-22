package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {
    List<Drugstore> findDrugstoresByUser(User user);
}
