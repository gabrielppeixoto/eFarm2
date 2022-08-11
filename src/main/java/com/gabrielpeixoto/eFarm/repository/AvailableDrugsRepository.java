/**
 * Interface para definir as consultas à tabela 'available_drugs' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.AvailableDrugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableDrugsRepository extends JpaRepository<AvailableDrugs, Long> {
    /**
     * Retorna um produto pelo nome
     * @param name o nome a ser pesquisado
     * @return o medicamento com o nome passado
     */
    AvailableDrugs findByProductName(String name);
}
