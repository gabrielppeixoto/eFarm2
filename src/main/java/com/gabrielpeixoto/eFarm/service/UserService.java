/**
 * Interface que define alguns tipos de consultas para usuários
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.service;

import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * Obtém todos os usuários
     * @return uma lista com os usuários
     */
    List<User> getAllUsers();

    /**
     * Cadastra um usuário no banco de dados
     * @param user o usuário a ser cadastrado
     * @return os dados do usuário salvo
     */
    User saveUser(User user);

    /**
     * Obtém um usuário via ID
     * @param id o ID do usuário a ser buscado
     * @return o usuário com o ID dado
     */
    User getUserById(Long id);

    /**
     * Obtém um usuário via e-mail
     * @param email o e-mail do usuário a ser buscado
     * @return o usuário com o e-mail dado
     */
    User getUserByEmail(String email);

    /**
     * Obtém os usuários com o nome dado
     * @param name o nome dos usuários a ser buscado
     * @return uma lista com todos os usuários que possuem aquele nome
     */
    List<User> getUsersByName(String name);

    /**
     * Obtém um usuário via identidade
     * @param idn a identidade do usuário a ser buscada
     * @return o usuário com a identidade dada
     */
    User getUserByIdentityNumber(String idn);

    /**
     * Atualiza informações de dado usuário
     * @param user o usuário cujas informações serão alteradas
     * @return o usuário com as informações alteradas
     */
    User updateUser(User user);

    /**
     * Remove o usuário do banco de dados
     * @param id o ID do usuário a ser eliminado
     */
    void deleteUserById(Long id);
}
