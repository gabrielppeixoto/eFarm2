/**
 * Interface para definir as consultas à tabela 'drugstore' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {
    /**
     * Retorna todos os estabelecimentos de um usuário
     * @param user o usuário do qual serão retornadas as farmácias
     * @return uma lista com as farmácias encontradas, ou null se não houver
     */
    List<Drugstore> findDrugstoresByUser(User user);

    /**
     * Retorna todas as farmácias que contém determinado medicamento
     * @param name o nome do medicamento a ser pesquisado
     * @return uma lista com todas as farmácias que o possuem
     */
    @Query(value = "select * from drugstore d, product p where p.product_name = ?1", nativeQuery = true)
    List<Drugstore> findDrugstoresByStoreContainingDrug(String name);

    @Query(value = "select count(*) from drugstore d, product p where p.product_name = ?1", nativeQuery = true)
    Integer countDrugstoresByDrug(String name);
}
