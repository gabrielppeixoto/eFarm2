/**
 * Interface para definir as consultas à tabela 'logged_user' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */
package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.LoggedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {
    @Query(value = "select * from logged_user where id=(select max(id) from logged_user)", nativeQuery = true)
    String getLastLoggedUser();
}
