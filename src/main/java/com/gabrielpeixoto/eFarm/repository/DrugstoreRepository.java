/**
 * Interface para definir as consultas à tabela 'drugstore' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.Drugstore;
import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
