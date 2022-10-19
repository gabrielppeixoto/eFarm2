/**
 * Interface para definir as consultas à tabela 'address' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
