/**
 * Interface para definir as consultas à tabela 'user' do banco de dados
 * @author Gabriel Porto Santos Peixoto
 */


package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Retorna o usuário com o nome dado
     * @param completeName o nome de usuário a ser pesquisado
     * @return o usuário com o nome dado
     */
    public List<User> findByCompleteName(String completeName);

    /**
     * Retorna o usuário com a identidade dada
     * @param identityNumber a identidade a ser pesquisada
     * @return o usuário com a identidade dada
     */
    public User findByIdentityNumber(String identityNumber);

    /**
     * Retorna o usuário com o e-mail dado
     * @param email o e-mail a ser pesquisado
     * @return o usuário com o e-mail dado
     */
    public User findByEmail(String email);
}
